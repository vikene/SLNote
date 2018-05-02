package com.vigneashsundar.slnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.vigneashsundar.slnotes.activites.ViewPads;

public class MainActivity extends AppCompatActivity {
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInAccount mAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart(){
        super.onStart();
        mAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(mAccount != null){
            Toast.makeText(getApplicationContext(), "USER ALREADY SIGNED IN", Toast.LENGTH_LONG).show();
            Intent shapeShifter = new Intent(getApplicationContext(), ViewPads.class);
            startActivity(shapeShifter);
        }
        else{
            Toast.makeText(getApplicationContext(),"PLEASE SIGNIN", Toast.LENGTH_LONG).show();
            signin();
        }
    }

    private void handleSigin(Task<GoogleSignInAccount> task){
        try{
            mAccount = task.getResult(ApiException.class);
            Log.d("ACCOUNTINFO",mAccount.getEmail());
            Intent shapeShifter = new Intent(getApplicationContext(), ViewPads.class);
            startActivity(shapeShifter);

        }
        catch (ApiException e){
            Log.d("APIEXCEPTION", "FAILED TASK");
        }

    }
    @Override
    public  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 25){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSigin(task);
        }
    }
    private void signin(){
        GoogleSignInOptions gops = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                                         .requestEmail()
                                                         .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gops);
        Intent signIn = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signIn,25);
    }
}
