import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class RemoveWebsites {

    public static ArrayList<String> removeWebsites(ArrayList<String> rawText){
        ArrayList<String> websitesRemoved = new ArrayList<>();

        String[] protocols = {"http", "https", "www"};

        for(String word : rawText){
            for(String protocol : protocols){
                if((word.contains(protocol))){
                    word = word + "REMOVE-ME";
                }
            }
            websitesRemoved.add(word);
        }

        ArrayList<String> holdingCell = new ArrayList<>();

        for(int i = 0; i < websitesRemoved.size(); i ++){
            if(!websitesRemoved.get(i).contains("REMOVE-ME")){
                holdingCell.add(websitesRemoved.get(i));
            }
        }

        websitesRemoved = holdingCell;

        return websitesRemoved;
    }
}
