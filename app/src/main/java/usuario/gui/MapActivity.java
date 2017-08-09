package usuario.gui;

import android.Manifest;
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

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private boolean local = true;
    private GoogleMap mMap;
    private static final String TAG = "Erro no Mapa";
    private Marker marker;

    LocationManager locationManager;

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
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

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

    }
    public void bancoLugares(){

        LatLng marcoZeroC = new LatLng(-8.063171, -34.871143);
        LatLng vivenciaC = new LatLng(-8.0174982,-34.9452835);
        CentroSaude marcoZero = new CentroSaude();
        marcoZero.setLocalizacao(marcoZeroC);
        marcoZero.setNome("Marco Zero");
        marcoZero.setEndereco("Ponto de partida do Recife");
        marcoZero.setTelefone("(81)3456-3563");
        marcoZero.setEspecializacao("Diversão");
        CentroSaude vivencia = new CentroSaude();
        vivencia.setLocalizacao(vivenciaC);
        vivencia.setNome("Espaço Vivência");
        vivencia.setEndereco("Agronomia");
        vivencia.setTelefone("(xx)xxxx-xxxx");
        vivencia.setEspecializacao("Lazer");

        LatLng unimed3L = new LatLng(-8.0645592,-34.8939489);
        CentroSaude unimed3 = new CentroSaude();
        unimed3.setLocalizacao(unimed3L);
        unimed3.setNome("Hospital Unimed Recife III");
        unimed3.setEndereco("Rua Jose De Alencar, 770, Boa Vista");
        unimed3.setTelefone("(81) 3320-7500");
        unimed3.setEspecializacao("Geral");

        LatLng albertL = new LatLng(-8.0659779,-34.8976523);
        CentroSaude albert = new CentroSaude();
        albert.setLocalizacao(albertL);
        albert.setNome("Hospital Albert Sabin");
        albert.setEndereco("R. Sen. José Henrique, 141 - Ilha do Leite");
        albert.setTelefone("(81)3131-7400");
        albert.setEspecializacao("Cirurgia Geral, Clínica Médica");
       // Obs: PLANOS DO ALBERT: unimed,camed,sulamerica

        LatLng memorialSaoJoseL= new LatLng(-8.0597126,-34.8974337);
        CentroSaude memorialSaoJose = new CentroSaude();
        memorialSaoJose.setLocalizacao(memorialSaoJoseL);
        memorialSaoJose.setNome("Hospital Memorial São José");
        memorialSaoJose.setEndereco("Avenida agamenom magalhaes, 2291, Boa vista");
        memorialSaoJose.setTelefone("(81)3216-2222");
        memorialSaoJose.setEspecializacao("Geral");

        LatLng hopeL = new LatLng(-8.0667061,-34.8963314);
        CentroSaude hope = new CentroSaude();
        hope.setLocalizacao(hopeL);
        hope.setNome("HOPE - Hospital de Olhos do Recife");
        hope.setEndereco("Rua francisco alves, 887, Ilha leite");
        hope.setTelefone("(81)3302-2040");
        hope.setEspecializacao("Oftalmologia");

        LatLng hoofL = new LatLng(-8.0401013,-34.9062553);
        CentroSaude hoof = new CentroSaude();
        hoof.setLocalizacao(hoofL);
        hoof.setNome("Hospital de Ortopedia e Fratura");
        hoof.setEndereco("Avenida rui barbosa, 1541, Graças");
        hoof.setTelefone("(81)3092-9777");
        hoof.setEspecializacao("ortopedia e traumatologia");

        LatLng hoseL = new LatLng(-8.0670954,-34.8974943);
        CentroSaude hose = new CentroSaude();
        hose.setLocalizacao(hoseL);
        hose.setNome("Hospital Esperança");
        hose.setEndereco("Rua antonio gomes de freitas, 265, Ilha do leite");
        hose.setTelefone("(81)3131-7878");
        hose.setEspecializacao("cirurgia cardíaca pediátrica, cirurgia neurológica pediátrica");

        LatLng rhosL = new LatLng(-8.0670954,-34.8974943);
        CentroSaude rhos = new CentroSaude();
        rhos.setLocalizacao(rhosL);
        rhos.setNome("Real Hospital Portugues");
        rhos.setEndereco("Avenida portugal, 163, Paissandu");
        rhos.setTelefone("(81)3416-1122");
        rhos.setEspecializacao("Geral");

        LatLng capsL = new LatLng(-8.0295025,-34.9238109);
        CentroSaude caps = new CentroSaude();
        caps.setLocalizacao(capsL);
        caps.setNome("Centro de Atenção Psicosocial Casa Forte");
        caps.setEndereco("Rua marechal rondon, 256, Casa forte");
        caps.setTelefone("(81)3441-0433");
        caps.setEspecializacao("Psiquiatria");

        LatLng jayL = new LatLng(-8.0511732,-34.9004814);
        CentroSaude jay = new CentroSaude();
        jay.setLocalizacao(jayL);
        jay.setNome("Hospital Jayme da Fonte");
        jay.setEndereco("Rua das pernambucanas, 103, Graças");
        jay.setTelefone("(81)3416-0037");
        jay.setEspecializacao("Cirugia geral,Clínica médica");

// PLANO sulamerica

        LatLng stajL= new LatLng(-8.052643,-34.8984431);
        CentroSaude staj = new CentroSaude();
        staj.setLocalizacao(stajL);
        staj.setNome("Hospital Santa Joana");
        staj.setEndereco("Rua Joaquim Nabuco 200, Graças");
        staj.setTelefone("(81)3216-6666");
        staj.setEspecializacao("Geral");

        LatLng avilaL = new LatLng(-8.0522372,-34.9090992);
        CentroSaude avila = new CentroSaude();
        avila.setLocalizacao(avilaL);
        avila.setNome("Hospital de Avila");
        avila.setEndereco("Av Visconde de Albuquerque 681, Madalena");
        avila.setTelefone("(81)3117-5544");
        avila.setEspecializacao("Geral");

//Hapvida

        LatLng hapesL= new LatLng(-8.0354903,-34.9162013);
        CentroSaude hapes = new CentroSaude();
        hapes.setLocalizacao(hapesL);
        hapes.setNome("Hapvida Espinheiro");
        hapes.setEndereco("R. José Luís da Silveira Barros, 134 - Espinheiro");
        hapes.setTelefone("(81)4002-2870");
        hapes.setEspecializacao("Dermatologia, Cardiologia e Ortopedia");


        customizadoAddMarker(marcoZero);
        customizadoAddMarker(vivencia);
        customizadoAddMarker(unimed3);
        customizadoAddMarker(hoof);
        customizadoAddMarker(hope);
        customizadoAddMarker(hose);
        customizadoAddMarker(rhos);
        customizadoAddMarker(jay);
        customizadoAddMarker(albert);
        customizadoAddMarker(hapes);
        customizadoAddMarker(avila);
        customizadoAddMarker(memorialSaoJose);
        customizadoAddMarker(caps);
    }

    public void customizadoAddMarker(CentroSaude lugar){
        MarkerOptions options = new MarkerOptions();

        options.position(lugar.getLocalizacao()).title(lugar.getNome())
                .snippet(lugar.getEndereco()+"\n"+lugar.getTelefone()+"\n"+lugar.getEspecializacao())
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
