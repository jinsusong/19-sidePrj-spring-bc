package poly.util;

import java.util.ArrayList;
import java.util.Date;

public class Block2 {
	public String hash;
	public String previousHash;
	public String merkleRoot;
	public ArrayList<Transaction2> transactions = new ArrayList<Transaction2>(); //our data will be a simple message.
	//private String data; //our data will be a simpole messge.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int nonce;
	
	//Block Constructor.
	public Block2(String previousHash) {
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	public String calculateHash() {
		String calculatedhash = Sha256_v2.applySha256(
				previousHash +
				Long.toString(timeStamp)+
				Integer.toString(nonce) +
				merkleRoot
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		merkleRoot = Sha256_v2.getMerkelRoot(transactions);
		String target = Sha256_v2.getDificultyString(difficulty);//create a string with difficulty * "0"
		while(!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
	//Add transactions to this block
	public boolean addTransaction(Transaction2 transaction) {
		//process transaction and check if valid, unless block is genesis block then ignore.
		if(transaction == null) return false;
		if((previousHash != "0")) {
			if((transaction.processTransaction() != true)) {
				System.out.println("Transaction failed to process. Discarded.");
				return false;
			}
		}
		transactions.add(transaction);
		System.out.println("transaction successfully added to block");
		return true;
	}
}
