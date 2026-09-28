public class ServiceQueue {

    String[] requests;
    int front;
    int rear;

    public ServiceQueue(int size) {
        requests = new String[size];
        front = 0;
        rear = -1;
    }

    public void enqueue(String request) {

        if (rear == requests.length - 1) {
            System.out.println("Queue is full.");
            return;
        }

        rear++;
        requests[rear] = request;

        System.out.println("Service request added successfully.");
    }

    public String dequeue() {

        if (front > rear) {
            return null;
        }

        String request = requests[front];
        front++;

        return request;
    }

    public void display() {

        if (front > rear) {
            System.out.println("No service requests.");
            return;
        }

        System.out.println("\n===== SERVICE REQUESTS =====");

        for (int i = front; i <= rear; i++) {
            System.out.println(requests[i]);
        }
    }
}