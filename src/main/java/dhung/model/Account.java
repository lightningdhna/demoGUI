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
    public void setAccessAuthority(String string){
        accessAuthority = string;
    }
    public void assign(Account account) {
        this.id = account.id;
        this.password= account.password;
        this.username= account.username;
        this.accessAuthority= account.accessAuthority;
    }
    public int getId(){
        return id;
    }
}
