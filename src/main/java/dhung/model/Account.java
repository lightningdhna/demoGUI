package dhung.model;

public class Account {
    private int id;
    private String username;
    private String password;
    private String accessAuthority;
    public Account(String username, String password){
        this.username=username;
        this.password=password;
    }
    public Account(int id, String username, String password,String accessAuthority){
        this(username, password);
        this.id=id;
        this.accessAuthority=accessAuthority;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getAccessAuthority(){
        return accessAuthority;
    }
    public int getId(){
        return id;
    }
}
