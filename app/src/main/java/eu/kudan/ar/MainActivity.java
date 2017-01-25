package eu.kudan.ar;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import eu.kudan.kudan.ARAPIKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARAPIKey key = ARAPIKey.getInstance();
//        key.setAPIKey("GAWAE-FBVCC-XA8ST-GQVZV-93PQB-X7SBD-P6V4W-6RS9C-CQRLH-78YEU-385XP-T6MCG-2CNWB-YK8SR-8UUQ");
        key.setAPIKey("lwoY4cyKEI+suoK+VyK2RtCjSMnzQRcsJmgAP8Uwt5MIJvxKCrE8rwLTCRxKQeuMMG9yG61W5J/53GpU0FdrDSNI6DDYoMWTQYcjvZ9kRWL2qW8782mk8Wem6T8orsVN977Ft+6biQIoTLWE4ZKJgd0BKjqwwkX17RYgjp1NCTTFnxhYzzmbA16ocun1Ks88bLjN2ONVlOwTrPBET+cFFTieoAx1HlPhT0G32k5qCDDhb/OkVYWHPtBxLfHW1HmRJLpC1Q7GIKVgHH+WAekrMDm6Sf7r+CrVxKsmTPmONojOvWo59y1EqwYOjntUOVtnptHpMNlM9MSC9gA9hl7A90lXRhVqoxGVJDPrNjFOYzCVhzECKZ7WupYjBvfHLq7LRSiT1dXVqMCU496QlF2pXlmVaICOMV0MtfkEQqstQBXvkFEAJVVbLr8eUQZZbXAYw5Rd3syT2zPYNIDpxJn2+vyIXFHR2AD1B7cUZxuYOJfbUSODUdkhUWB/MpFtYG8o677/ReB+vDmngFlvz16hR0gOdauHzX0nhl8l0N3MjhjKF4dxqIrqmc0W2g2fSDHga7frddX2JRgOgJEsmJYldNe7FXMjUNsUdCuMEEf9YVwpDoyqQYZzNNseZOBtIPS+1eHhtlmTg7egvIIU9XQPrz7b/zxEVuw7ObTv8PmmxyI=");

        permissionsRequest();

    }

        // Requests app permissions
    public void permissionsRequest() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 111);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 111: {
                if (grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED ) {

                } else {
                    permissionsNotSelected();
                }
            }
        }
    }

    private void permissionsNotSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setTitle("Permissions Requred");
        builder.setMessage("Please enable the requested permissions in the app settings in order to use this demo app");
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                System.exit(1);
            }
        });
        AlertDialog noInternet = builder.create();
        noInternet.show();
    }


    public void startARActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ARCameraViewActivity.class);
        startActivity(intent);
    }
}