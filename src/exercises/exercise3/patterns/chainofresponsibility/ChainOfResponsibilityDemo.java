package exercises.exercise3.patterns.chainofresponsibility;

/** Routes support requests through an ordered chain of handlers. */
public final class ChainOfResponsibilityDemo {

    private ChainOfResponsibilityDemo() {
    }

    public static void run() {
        Handler chain = new TechnicalHandler();
        chain.setNext(new BillingHandler()).setNext(new GeneralHandler());
        chain.handle(new SupportRequest(RequestType.TECHNICAL, 3, "Laptop will not start"));
        chain.handle(new SupportRequest(RequestType.BILLING, 2, "Invoice question"));
        chain.handle(new SupportRequest(RequestType.GENERAL, 1, "Where is the office?"));
    }

    private enum RequestType { TECHNICAL, BILLING, GENERAL }
    private record SupportRequest(RequestType type, int priority, String message) { }

    private abstract static class Handler {
        private Handler next;

        Handler setNext(Handler next) {
            this.next = next;
            return next;
        }

        final void passOrHandle(SupportRequest request) {
            if (next == null) {
                System.out.println("No handler for: " + request.message());
            } else {
                next.handle(request);
            }
        }

        abstract void handle(SupportRequest request);
    }

    private static final class TechnicalHandler extends Handler {
        void handle(SupportRequest request) {
            if (request.type() == RequestType.TECHNICAL && request.priority() >= 2) {
                System.out.println("Technical support handled: " + request.message());
            } else {
                passOrHandle(request);
            }
        }
    }

    private static final class BillingHandler extends Handler {
        void handle(SupportRequest request) {
            if (request.type() == RequestType.BILLING && request.priority() >= 2) {
                System.out.println("Billing support handled: " + request.message());
            } else {
                passOrHandle(request);
            }
        }
    }

    private static final class GeneralHandler extends Handler {
        void handle(SupportRequest request) {
            System.out.println("General support handled: " + request.message());
        }
    }
}
