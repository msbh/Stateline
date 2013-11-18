package com.example.test2;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private WebView webView;
    Boolean isInternetPresent = false;
    
    // Connection detector class
    ConnectionDetector cd;
    
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        view.loadUrl(url);
//        return true;
//    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        cd = new ConnectionDetector(getApplicationContext());
	        
	        webView = (WebView) findViewById(R.id.webView);
	        
	        webView.setWebViewClient(new Callback());// to stable without browser 
	        // get Internet status
            isInternetPresent = cd.isConnectingToInternet();

            // check for Internet status
            if (isInternetPresent) {
            	   webView.loadUrl("http://www.statelineproducts.com/");

      			 
       	        webView.getSettings().setJavaScriptEnabled(true);
                // Internet Connection is Present
                // make HTTP requests
              //  showAlertDialog(MainActivity.this, "Internet Connection", "You have internet connection", true);
            } else {
                // Internet connection is not present
                // Ask user to connect to Internet
                showAlertDialog(MainActivity.this, "No Internet Connection",
                        "You don't have internet connection.", false);
                finish();
            }
            
            
	     
	       
	        //String customHtml = "<html><body><h2>Greetings from JavaCodeGeeks</h2></body></html>";
	       // webView.loadData(customHtml, "text/html", "UTF-8");
	      
	}



    private class Callback extends WebViewClient{  //HERE IS THE MAIN CHANGE. 

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }

    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


public void showAlertDialog(Context context, String title, String message, Boolean status) {
    AlertDialog alertDialog = new AlertDialog.Builder(context).create();

    // Setting Dialog Title
    alertDialog.setTitle(title);

    // Setting Dialog Message
    alertDialog.setMessage(message);
    // Showing Alert Message
    alertDialog.show();

    // Setting alert dialog icon
//     alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

    // Setting OK Button
    alertDialog.setButton("OK",new DialogInterface.OnClickListener() {   
        public void onClick(DialogInterface dialog, int which) {
      }
    
    });
    
}

 
}