package lecture18;

public class HashNode {
	String key;
	Integer data;
	HashNode next;

	public HashNode(String k, Integer v, HashNode next){
		this.key = k;
		this.data = v;
		this.next = next; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	public boolean equals(HashNode other) {
		if (other == null) return false;
		return key.equals(other.key);
	}
	
	public String toString(){
		return key + ", " + data;
	}
	public static void main(String[] args) {
		HashNode n = new HashNode("a",0,null);
		System.out.println(n.hashCode()+", "+"a".hashCode());
	}
}
