package traviator42.dto;

import java.util.ArrayList;

public class Village {
    public String name = "";
    public String url = "";
    int X;
    int Y;
    //это имя здания
    public ArrayList<String> buildList = new ArrayList<>();
    public ArrayList<String> buildListD = new ArrayList<>();
    
    //это номер здания. Нужен для оранжевых кругов и даблстроя
    public ArrayList<Integer> idList = new ArrayList<>();
    public ArrayList<Integer> idListD = new ArrayList<>();
    
    //то что сносим
    public ArrayList<String> demolishList = new ArrayList<>();
    public ArrayList<Integer> dLevel = new ArrayList<>();
    
    public String time = "";
    public String period = "30";
    public String timeDouble = "";
    public String periodDouble = "30";
    
    public String dTime = "";
    public String dPeriod = "30";
    
    public String storeLevel = "0";
    public String granaryLevel = "0";
    public String mainBuildLevel = "0";
}
