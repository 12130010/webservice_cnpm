package test;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.nhuocquy.model.Account;
import com.nhuocquy.model.Conversation;
import com.nhuocquy.model.Friend;

public class TestJackson {
	public static void main(String[] args) {
		Account ac = new Account();
		ac.setIdAcc(1);
		ac.setName("Nhuoc Quy");
		ac.setPassword("nhuoc quy");
		ac.setUsername("nhuoc quy");
//		ac.setListFrs(new ArrayList<Friend>());
//		ac.setConversations(new ArrayList<Conversation>());
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			System.out.println(objectMapper.writeValueAsString(ac));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
