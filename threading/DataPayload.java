package threading;

public class DataPayload {
    String data;

    public DataPayload(String data) {
        this.data = data;
    }

    public synchronized void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }
}
