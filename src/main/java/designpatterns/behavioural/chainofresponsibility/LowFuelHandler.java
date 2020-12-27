package designpatterns.behavioural.chainofresponsibility;

public class LowFuelHandler extends AbstractHandler {

    // Only interested in handling requests with code 1
    private static int code = 2;

    public LowFuelHandler(AbstractHandler successor) {
        super(successor);
    }

    @Override
    public void handleRequest(AbstractRequest request) {
        if (code == request.getRequestCode()) {
            // Handle the request here.
        } else {
            // If the handler, doesn't handle these type of
            // requests, it can just call the super class's
            // forward request method.
            super.handleRequest(request);
        }
    }

}
