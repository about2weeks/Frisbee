package login;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Map {

	double x;
	double y;
	
	public Map() {
		
	}
	
	public Map(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	public Map getLoc(String loc) {
		String apiURL = "http://api.vworld.kr/req/address";
        
		Map map = new Map();
		
        try{
                //주소 넣기 
              
              String text_content =  URLEncoder.encode(loc.toString(), "utf-8");
               
              // post request
              String postParams = "service=address";
                     postParams += "&request=getcoord";                     
                     postParams += "&version=2.0";
                     postParams += "&crs=EPSG:4326";
                     postParams += "&address="+text_content;                                    
                     postParams += "&arefine=true";
                     postParams += "&simple=false";                  
                     postParams += "&format=json";
                     postParams += "&type=road";    
                     postParams += "&errorFormat=json";
                     postParams += "&key=380EA838-030D-3F43-9E23-32163936CFE9";                    
 
              
          /*    DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
              DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
              Document doc = dBuilder.parse(apiURL+"?"+postParams);

                     // root tag 
              doc.getDocumentElement().normalize();   
              
              Node nNode = doc.getElementsByTagName("point").item(0);
              Element e = (Element) nNode;
              map.x = Double.valueOf(getTagValue("x", e));
              map.y = Double.valueOf(getTagValue("y", e));
             
              System.out.println(map.x+" "+map.y);*/
         
              int responseCode = 0;
              URL url = new URL(apiURL);
              HttpURLConnection con = (HttpURLConnection)url.openConnection();
              con.setRequestMethod("POST");
              
              con.setDoOutput(true);
              DataOutputStream wr = new DataOutputStream(con.getOutputStream());
              wr.writeBytes(postParams);
              wr.flush();
              wr.close();
              responseCode = con.getResponseCode();
              BufferedReader br;
               
              if(responseCode==200) { // 정상 호출
                  br = new BufferedReader(new InputStreamReader(con.getInputStream()));
              }else{  // 에러 발생
            	  System.out.println("error!");
                  br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
              }
 
              String inputLine;
              String response = new String();
 
              while ((inputLine = br.readLine()) != null) {
                  response = response + inputLine;
              }
             // System.out.println("response : " + response);
              br.close();
              con.disconnect();
              
              JsonParser jp = new JsonParser();
              JsonObject jo = (JsonObject) jp.parse(response);
              JsonObject jre = (JsonObject) jo.get("response");
              JsonObject jr = (JsonObject) jre.get("result");
              JsonObject point = (JsonObject) jr.get("point");
              map.x = point.get("x").getAsDouble();
              map.y = point.get("y").getAsDouble();
              
              //System.out.println(map.x+" "+map.y);
              
          }catch(Exception e){          
              e.printStackTrace();
          }
        
        return map;
	}
	
	private String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
	
	public double getDistance(double x1, double y1, double x2, double y2) {
		
		double theta = y1 - y2;
        double dist = Math.sin(deg2rad(x1)) * Math.sin(deg2rad(x2)) + Math.cos(deg2rad(x1)) * Math.cos(deg2rad(x2)) * Math.cos(deg2rad(theta));
          
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
          
        dist = dist * 1.609344;
        
        
        return (dist);
	
	}
	
	 private double deg2rad(double deg) {
	        return (deg * Math.PI / 180.0);
	    }
	      
	    // This function converts radians to decimal degrees
	 private double rad2deg(double rad) {
	        return (rad * 180 / Math.PI);
	 }

	
}
