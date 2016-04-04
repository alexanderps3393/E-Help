//package com.example.gawat;
//
//import java.util.Random;
//
//import android.app.Activity;
//import android.os.StrictMode;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.Toast;
// 
//	public class GMailMain extends Activity {
//
//	    @Override
//	    public void onCreate(Bundle savedInstanceState) {
//	        super.onCreate(savedInstanceState);
//	        requestWindowFeature(Window.FEATURE_NO_TITLE);
//	        
//	        
//	        setContentView(R.layout.main);
//
////	        LinearLayout addImage = (LinearLayout) findViewById(R.id.send);
////	        addImage.setOnClickListener(new View.OnClickListener() {
////	            public void onClick(View view) {
////	               
////	               
////	                GMailSender mailsender = new GMailSender("sartikasarihasibuan@gmail.com", "(*sartika*)");
////
////	                EditText to = (EditText) findViewById(R.id.etEmailRSakit);
////	                String[] toArr = { to.getText().toString() };
////	                mailsender.set_to(toArr);
////	                mailsender.set_from("sartikasarihasibuan@gmail.com");
////	                mailsender.set_subject("Verifikasi Akun Aplikasi E-Help");
////	                mailsender.setBody("Selamat anda berhasil terdaftar sebagai petugas Rumah Sakit pada Aplikasi E-Help. Masukkan Kode berikut "+random()+" pada form Login");
////
////	                try {
////	                    //mailsender.addAttachment("/sdcard/filelocation");
////
////	                    if (mailsender.send()) {
////	                        Toast.makeText(GMailMain.this,
////	                                "Email was sent successfully.",
////	                                Toast.LENGTH_LONG).show();
////	                    } else {
////	                        Toast.makeText(GMailMain.this, "Email was not sent.",
////	                                Toast.LENGTH_LONG).show();
////	                    }
////	                } catch (Exception e) {
////	                   
////	                    Log.e("MailApp", "Could not send email", e);
////	                }
////	            }
////	        });
////
////	    }
////	    public static String random() {
////	    	int MAX_LENGTH = 20;
////	        Random generator = new Random();
////	        StringBuilder randomStringBuilder = new StringBuilder();
////	        int randomLength = generator.nextInt(MAX_LENGTH);
////	        char tempChar;
////	        for (int i = 0; i < randomLength; i++){
////	            tempChar = (char) (generator.nextInt(96) + 32);
////	            randomStringBuilder.append(tempChar);
////	        }
////	        return randomStringBuilder.toString();
////	    }
////	}