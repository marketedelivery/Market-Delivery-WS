import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mercadopago.MP;

/**
 * 
 */
/**
 * @author Audry Martins
 *
 */
public class Teste
{
	public static void main(String args[])
	{
		MP mp = new MP("5952939985037689", "sc6bzJ8ZWHkhAU3xnt0Krx0sq0DS2zcM");
		String accessToken = "";
		try
		{
			accessToken = mp.getAccessToken();
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(accessToken);
		JSONObject preference = null;
		try
		{
			preference = mp.getPreference("29198094-ec99d152-610e-4438-8228-b5a1f0fa2606");
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(preference.toString());
	}
}