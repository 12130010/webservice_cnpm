package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.nhuocquy.model.Account;
import com.nhuocquy.model.Conversation;
import com.nhuocquy.model.Friend;
import com.nhuocquy.model.MessageChat;

public class TestJackson {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Account ac = new Account();
		ac.setIdAcc(1);
		ac.setName("Nhuoc Quy");
		ac.setPassword("nhuoc quy");
		ac.setUsername("nhuoc quy");
		List<Friend> listFre = new ArrayList<Friend>();
		listFre.add(new Friend(1, "hehe"));
		listFre.add(new Friend(2, "hihi"));
		ac.setListFrs(listFre);
		List<Conversation> listCon = new ArrayList<Conversation>();
		listCon.add(new Conversation(1, listFre, new ArrayList<MessageChat>()));
		ac.setConversations(listCon);
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		
//		try {
//			System.out.println(objectMapper.writeValueAsString(ac));
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("G:\\ob.txt"));
		ob.writeObject(ac);
		ob.close();
		ObjectInputStream ob2 = new ObjectInputStream(new FileInputStream("G:\\ob.txt"));
		System.out.println(ob2.readObject());
		ob2.close();
	}
}
