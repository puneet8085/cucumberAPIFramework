package payload;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public AddPlace addPlacePayload(String name,String language,String address)
    {

        AddPlace ap=new AddPlace();
        ap.setAccuracy(100);
        ap.setAddress(address);
        ap.setLanguage(language);
        ap.setName(name);
        ap.setPhone_number(11111);
        ap.setWebsite("www.google.com");
        Location loc = new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        ap.setLocation(loc);
        List<String> mylist = new ArrayList<String>();
        mylist.add("value 1");
        mylist.add("value 2");
        ap.setTypes(mylist);

        return ap;
    }

    //payload for delete place api
    public String deletePlacePayload(String placeid)
    {
        return "{\n" +
                "    \"place_id\":\""+placeid+"\"\n" +
                "}\n";
    }
}
