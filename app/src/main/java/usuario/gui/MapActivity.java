package usuario.gui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
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
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import usuario.dominio.CentroSaude;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "teste";
    private boolean local = true;
    private GoogleMap mMap;
    private Marker marker;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
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
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

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
                        e.printStackTrace();
                    }

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
/*
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(this, R.raw.mapaestilo));
            if (!success) {
                Log.e(TAG, "Falhou ao aplicar estilo.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Estilo não encontrado. Error: ", e);
        }
*/
        mMap = googleMap;
        mMap.setMinZoomPreference(13.0f);
        bancoLugares();

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
                    TextView infos = v.findViewById(R.id.endereçoId);
                    //Button rota = (Button) v.findViewById(R.id.rotaId);
                    //View imagem = v.findViewById(R.id.imagemId);

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
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

//EVENTOS
        /*
        mMap.addMarker(new MarkerOptions().position(teste).title("Marcador teste")
                .snippet("BRASIL KRAI")
                .icon(BitmapDescriptorFactory.fromResource(R.raw.marcador2)));


        mMap.addMarker(new MarkerOptions().position(marcoZero).title("Marcador no Marco Zero")
                .icon(BitmapDescriptorFactory.fromResource(R.raw.marcador2)));

        mMap.setOnMapClickListener(GoogleMap.OnMapClickListener); */
    }
    public void bancoLugares(){

        LatLng marcoZeroC = new LatLng(-8.063171, -34.871143);
        LatLng testeC = new LatLng(-8.061, -34.8707);
        CentroSaude marcoZero = new CentroSaude();
        marcoZero.setLocalizacao(marcoZeroC);
        marcoZero.setNome("Marco Zero");
        marcoZero.setEndereco("Ponto de partida do Recife");
        marcoZero.setTelefone("(81)3456-3563");
        CentroSaude teste2 = new CentroSaude();
        teste2.setLocalizacao(testeC);
        teste2.setNome("Marker2");
        teste2.setEndereco("Ponto para teste");
        teste2.setTelefone("(81)4673-3563");

        customizadoAddMarker(marcoZero);
        customizadoAddMarker(teste2);
    }

    public void customizadoAddMarker(CentroSaude lugar){
        MarkerOptions options = new MarkerOptions();

        options.position(lugar.getLocalizacao()).title(lugar.getNome())
                .snippet(lugar.getEndereco()+"\n"+lugar.getTelefone())
                .icon(BitmapDescriptorFactory.fromResource(R.raw.marcador2));

        this.marker = this.mMap.addMarker(options);
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
}
