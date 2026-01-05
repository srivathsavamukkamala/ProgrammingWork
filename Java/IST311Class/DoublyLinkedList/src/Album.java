import java.util.ArrayList;

public class Album implements Comparable<Album>{

    private int albumId; //UID of the specific object
    private static int lastId; //Keeps track of the last id

    private ArrayList<String> names;

    private int numOfSongs;


    //Empty Constructor
    public Album(){
        lastId++;
        albumId = lastId;
        this.names = new ArrayList<>();
        this.numOfSongs = 0;
    }

    //If they can provide names and numOfSongs
    public Album(ArrayList<String> names, int numOfSongs){
        lastId++;
        albumId = lastId;
        this.names = names;
        this.numOfSongs = numOfSongs;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Override
    public int compareTo(Album o) {
        if(this.numOfSongs==o.numOfSongs){
            return 0;
        }else if(this.numOfSongs>o.numOfSongs){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        String ret = this.albumId + ": "+ numOfSongs + " -- ";
        String listOfNames = "[";
        for(int i=0;i<this.names.size();i++){
            if(i==this.names.size()-1){
                listOfNames=listOfNames+this.names.get(i);
            }else{
                listOfNames=listOfNames+this.names.get(i)+", ";
            }
        }
        listOfNames+="]";
        ret += listOfNames;
        return ret;
    }
    public static void resetId() {
        Album.lastId = 0;
    }
}
