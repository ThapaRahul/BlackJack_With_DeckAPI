import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class URLParseToMap {
	
	//private static String urlString;
	
	public URLParseToMap () {
		
	}
	
public static String jsonToString(String urlString) throws JSONException{
		
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	      HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	      try {
			con.setRequestMethod("GET");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
	      try {
			int status = con.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	      BufferedReader in = null;
		try {
			in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String inputLine;
	    StringBuffer content = new StringBuffer();
	    try {
	    	while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	  	try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return content.toString();
    }

	public static HashMap<String, Object> jsonstringToMap(String t) throws JSONException{
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    JSONObject jObject = null;
		try {
			jObject = new JSONObject(t);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    Iterator<?> keys = jObject.keys();
	
	    while( keys.hasNext() ){
	        String key = (String)keys.next();
	         Object value = null;
			try {
				value = jObject.get(key);
			} catch (JSONException e) {
				e.printStackTrace();
			} 
	        map.put(key, value);
	
	    }
	    return map;
	}
	
	
	
	public static HashMap<String, Object> jsonToMap(String urlString) throws JSONException{
		
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	      HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	      try {
			con.setRequestMethod("GET");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
	      try {
			int status = con.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	      BufferedReader in = null;
		try {
			in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String inputLine;
	    StringBuffer content = new StringBuffer();
	    try {
	    	while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	  	try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  	String t = content.toString();

        HashMap<String, Object> map = new HashMap<String, Object>();
        JSONObject jObject = null;
		try {
			jObject = new JSONObject(t);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
             Object value = null;
			try {
				value = jObject.get(key);
			} catch (JSONException e) {
				e.printStackTrace();
			} 
            map.put(key, value);

        }
        return map;
    }
}
