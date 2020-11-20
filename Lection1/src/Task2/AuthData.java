package Task2;

public class AuthData implements Comparable {
    private int count;
    private String password;

    public AuthData(String password) {
        this.password = password;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public String getPassword() {
        return password;
    }

    public void iterateCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "password = " + password ;
    }

    @Override
    public boolean equals(Object obj) {
        return password.equals(((AuthData)obj).getPassword());
    }

    @Override
    public int compareTo(Object o) {
        return ((AuthData)o).getCount() - count;
    }
}
