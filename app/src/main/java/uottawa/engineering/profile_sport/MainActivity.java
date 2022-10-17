package uottawa.engineering.profile_sport;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.*;
import android.net.Uri;
import android.widget.EditText;
import android.os.Bundle;
import android.content.*;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_CANCELED)return;

        ImageView avatarImage = (ImageView) findViewById(R.id.Logo);

        String drawableName = "ic_logo_00";
        switch(data.getIntExtra("ImageId", R.id.Logo)){
            case R.id.Logo:
                drawableName = "ic_logo_00";
                break;
            case R.id.ic_logo_01:
                drawableName = "ic_logo_01";
                break;
            case R.id.ic_logo_02:
                drawableName = "ic_logo_02";
                break;
            case R.id.ic_logo_03:
                drawableName = "ic_logo_03";
                break;
            case R.id.ic_logo_04:
                drawableName = "ic_logo_04";
                break;
            case R.id.ic_logo_05:
                drawableName = "ic_logo_05";
                break;
            case R.id.ic_logo_06:
                drawableName = "ic_logo_06";
                break;
        }
        int resID = getResources().getIdentifier(drawableName,"drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
    public void OnOpenInGoogleMaps(View view){
        EditText adress=(EditText) findViewById(R.id.Adress);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+adress.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void OnClickLogo(View view){

        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent,0);
    }
    }