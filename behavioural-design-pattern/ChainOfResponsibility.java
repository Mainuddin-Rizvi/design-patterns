// Handler Interface
interface SupportHandler {
    void setNextHandler(SupportHandler nextHandler);
    void handleRequest(String request);
}

// Concrete Handler 1
class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Level 1")) {
            System.out.println("Level 1 support handled the request.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}

// Concrete Handler 2
class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Level 2")) {
            System.out.println("Level 2 support handled the request.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}

// Concrete Handler 3
class Level3SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Level 3")) {
            System.out.println("Level 3 support handled the request.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("No handler available for the request.");
            }
        }
    }
}

// Client
public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Create handlers
        SupportHandler level1 = new Level1SupportHandler();
        SupportHandler level2 = new Level2SupportHandler();
        SupportHandler level3 = new Level3SupportHandler();

        // Set the chain of responsibility
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        // Send requests
        System.out.println("Sending request to Level 1:");
        level1.handleRequest("Level 1");

        System.out.println("\nSending request to Level 2:");
        level1.handleRequest("Level 2");

        System.out.println("\nSending request to Level 3:");
        level1.handleRequest("Level 3");

        System.out.println("\nSending request to unknown level:");
        level1.handleRequest("Level 4");
    }
}
