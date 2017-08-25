package usuario.gui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import usuario.dominio.CentroSaude;
import usuario.negocio.CentroSaudeNegocio;
import usuario.negocio.SessaoUsuario;

/**
 * <h1>MapActivity</h1>
 * Activity responsavel pelas funcionalidade do mapa do aplicativo.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private boolean local = true;
    private GoogleMap mMap;
    private static final String TAG = "Erro no Mapa";
    private Marker marker;
    private SessaoUsuario sessao;
    private CentroSaudeNegocio centroSaudeNegocio;

    LocationManager locationManager;

    /**
     * O metodo onCreate() tem a funcionalidade de setar o layout: activity_map, cria o fragmento
     * para o mapa, pega permissao de gps do dispositivo e com isso mostra onde esta o usuario no
     * mapa e inicia a sessao.
     *
     * @param savedInstanceState Objeto da classe Bundle que contem o estado anterior da activity.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
        
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LatLng latLng = new LatLng(latitude, longitude);
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String string = addressList.get(0).getLocality();
                        if(isLocal()){
                            mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(latLng , 17.0f) );
                            setLocal(false);
                        }
                    } catch (IOException e) {
                        Log.e(TAG,Log.getStackTraceString(e));
                    }
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LatLng latLng = new LatLng(latitude, longitude);
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String string = addressList.get(0).getLocality();
                        if(isLocal()){
                            mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(latLng , 17.0f) );
                            setLocal(false);
                        }
                    } catch (IOException e) {
                        Log.e(TAG,Log.getStackTraceString(e));
                    }
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }

            });

        }
        sessao = new SessaoUsuario(getApplicationContext());
        sessao.iniciarSessao();
        centroSaudeNegocio = new CentroSaudeNegocio();
    }

    /**
     * O metodo onMapReady() tem a funcionalidade de avisar quando o mapa está pronto para ser
     * usado pelo aplicativo e depois inicia o metodo iniciarHospitais() da mesma classe.
     *
     * @param googleMap Objeto GoogleMap.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMinZoomPreference(13.0f);


        if(mMap != null){
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.infowindow_map,null);

                    TextView titulo = v.findViewById(R.id.tituloId);
                    TextView infos = v.findViewById(R.id.enderecoId);

                    titulo.setText(marker.getTitle());
                    infos.setText(marker.getSnippet());
                    return v;
                }
            });
        }

        mMap.setMyLocationEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        iniciarHospitais();
    }

    /**
     * O metodo iniciarHospitais() tem a funcionalidade de criar uma List de objetos CentroSaudes
     * achadas pelo metodo: getHospitais() da classe CentroSaudeNegocio() e chama o metodo:
     * customizadorAddMarker() dessa mesma classe para povoar o mapa do aplicativo.
     *
     * @see CentroSaudeNegocio#getHospitais(Context, String)
     * @see MapActivity#customizadoAddMarker(CentroSaude)
     */

   public void iniciarHospitais(){
       List<CentroSaude> centroSaudes = centroSaudeNegocio.getHospitais(getApplicationContext(),sessao.getPessoaLogada().getPlanoSaude());
       for (int x = 0; x<centroSaudes.size(); x++){
           customizadoAddMarker(centroSaudes.get(x));
       }
   }

    /**
     * O metodo customizadorAddMarker() tem a funcionalidade de pegar as informacoes de um objeto
     * CentroSaude e criar um marcador com as informacoes numa infoWindow no mapa do aplicativo.
     *
     * @param lugar Objeto CentroSaude.
     */

    public void customizadoAddMarker(CentroSaude lugar){
        MarkerOptions options = new MarkerOptions();

        options.position(lugar.getLocalizacao()).title(lugar.getNome())
                .snippet(lugar.getEndereco()+"\n"+lugar.getTelefone()+"\n"+lugar.getEspecializacao())
                .icon(BitmapDescriptorFactory.fromResource(R.raw.marcador2));

        this.marker = this.mMap.addMarker(options);
    }

    /**
     * O metodo isLocal() tem a funcionalidade de ser uma flag.
     * @return Retorna uma booleana.
     */
    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
}
