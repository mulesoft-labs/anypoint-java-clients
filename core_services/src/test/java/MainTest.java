import org.mule.cs.api.CoreServicesAPIReferenceClient;

import org.mule.cs.resource.api.me.model.MeGETResponseBody;
import org.mule.cs.responses.CoreServicesAPIReferenceResponse;

public class MainTest {
    public static void main(String[] args) {
        CoreServicesAPIReferenceClient client = CoreServicesAPIReferenceClient.create();
        try {
            CoreServicesAPIReferenceResponse<MeGETResponseBody> response = client.api.me.get("731c4dbc-fc38-4874-88c9-e8fbe10ca80");
            System.out.println("response = " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
