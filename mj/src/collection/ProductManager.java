package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
	
	// constants
	public final static String ALL = "All";
	
	public final static String ELEC = "Electronics";
	public final static String BOOK = "Books";

	public final static String COMPUTER = "Computer";
	public final static String LAPTOP = "Laptop";
	public final static String TABLET = "Tablet";
	
	public final static String MACBOOKS = "MacBooks";
	public final static String LENOVO = "Lenovo";
	public final static String DELL = "Dell";
	
	public final static String THREE_D = "3D";
	public final static String TV = "TV";
	public final static String SMART_TV = "Smart TV";
	public final static String LED_TV = "LED TV";
	
	public final static String CAMERA = "Camera";
	public final static String CELLPHONE = "Cellphone";
	
	private static Map<String, ProdTreeNode> treeMap = new HashMap<String, ProdTreeNode>();
	

	public static void main(String[] args) {
		
		
		ProductManager manager = new ProductManager();
		
		ProdTreeNode root = manager.generateTree(ALL);
		
		String input = COMPUTER;
		
		List<ProdTreeNode> proudcts = manager.getProductsByCategoryr(root, input);
		
		//print out product;
		System.out.println("1.INPUT category:"+input+",contains prouducts as below:");
		for (ProdTreeNode prod : proudcts) {
			System.out.println(prod.name);
		}
		System.out.println();
		
		// print out full path 
		String pathInput = "dellbook 2";
		System.out.println("2.The full path of '"+pathInput+"'is:");
		String path =manager.getPathByProduct(treeMap.get(pathInput));
		System.out.println(path);
	}

	/**
	 *  
	 * @param root
	 * @param cate
	 * @return
	 */
	public List<ProdTreeNode> getProductsByCategoryr(ProdTreeNode root, String cate) {

		ProdTreeNode node = treeMap.get(cate);
		if(node == null) {
			System.out.println("user input category don't has product");
			return null;  // user input category don't has product
		}
		// get node by name
		List<ProdTreeNode> products = new LinkedList<>();
		tranverse(node, products);
		return products;
	}
	
	
	private void tranverse(ProdTreeNode node, List<ProdTreeNode> products) {
		
		if(!node.isCategory()) {
			products.add(node);
			return;
		}
		for(ProdTreeNode n : node.getChildren()) {
			tranverse(n, products);
		}
	}


	public String getPathByProduct(ProdTreeNode root, String productName) {
		StringBuffer sb = new StringBuffer();
		
		ProdTreeNode node = getCategoryNodeName(root, productName);
		
		while(node.getParent()!= null) {
			sb.append(node.getParent().getName()).append("/");
			node = node.getParent();
		}
		
		return sb.toString();
	}
	
	
	public String getPathByProduct(ProdTreeNode node) {
		StringBuffer sb = new StringBuffer();
		sb.append(node.name).append("/");
		
		while(node.getParent()!= null) {
			sb.append(node.getParent().getName()).append("/");
			node = node.getParent();
		}
		
		return sb.toString();
	}

	private ProdTreeNode getCategoryNodeName(ProdTreeNode root, String cate) {
		if(root.name == cate)
			return root;
		
		Set<ProdTreeNode> childs = root.getChildren();
		for (ProdTreeNode ch : childs) {
			root = getCategoryNodeName(ch, cate);
			
		}
		return root;
	}

	/**
	 * construct a tree with products as leaf
	 * 
	 * Generate product tree.
	 * @param treeMap 
	 * @param rootName
	 * @param treeMap 
	 * @return
	 */
	public ProdTreeNode generateTree(String rootName) {
		
		ProdTreeNode root = new ProdTreeNode(rootName);
		ProdTreeNode elec = new ProdTreeNode(ELEC,root);
		ProdTreeNode book = new ProdTreeNode(BOOK,root);

		
		ProdTreeNode computer = new ProdTreeNode(COMPUTER,elec);
		ProdTreeNode camera = new ProdTreeNode(CAMERA,elec);
		ProdTreeNode cellphone = new ProdTreeNode(CELLPHONE,elec);
		ProdTreeNode loptop = new ProdTreeNode(LAPTOP,computer);
		ProdTreeNode tablet = new ProdTreeNode(TABLET,computer);

		
		ProdTreeNode macbook = new ProdTreeNode(MACBOOKS,loptop);
		ProdTreeNode lenovo = new ProdTreeNode(LENOVO,loptop);
		ProdTreeNode dell = new ProdTreeNode(DELL,loptop);
		
		ProdTreeNode tv = new ProdTreeNode(TV,elec);
		ProdTreeNode thrd = new ProdTreeNode(THREE_D,tv,false);
		ProdTreeNode smartTV = new ProdTreeNode(SMART_TV,tv,false);
		ProdTreeNode ledTV = new ProdTreeNode(LED_TV,tv,false);
	
	    root.getChildren().add(elec);
	    root.getChildren().add(book);
	    
	    elec.getChildren().add(computer);
	    computer.setParent(elec);
	    elec.getChildren().add(tv);
	    elec.getChildren().add(camera);
	    elec.getChildren().add(cellphone);
	    
	    computer.getChildren().add(loptop);
	    computer.getChildren().add(tablet);
	    
	    loptop.getChildren().add(macbook);
	    loptop.getChildren().add(dell);
	    loptop.getChildren().add(lenovo);
	   
		tv.getChildren().add(thrd);
		tv.getChildren().add(smartTV);
		tv.getChildren().add(ledTV);
		
		ProdTreeNode macbookAir1 = new ProdTreeNode("Macbook Air 1", macbook,false);
		ProdTreeNode macbookAir2= new ProdTreeNode("Macbook Air 2", macbook,false);
		
		// TODO: maintain parent info; This is due to previousl
		macbook.setParent(loptop);
		loptop.setParent(computer);
		computer.setParent(elec);
		macbook.getChildren().add(macbookAir1);
		macbook.getChildren().add(macbookAir2);
		
		//add new products
		ProdTreeNode dellbook1 = new ProdTreeNode("dellbook 1", dell,false);
		ProdTreeNode dellbook2 = new ProdTreeNode("dellbook 2", dell,false);
		dell.getChildren().add(dellbook1);
		dell.getChildren().add(dellbook2);
		
		lenovo.getChildren().add(new ProdTreeNode("lenovo 1",lenovo,false));
		lenovo.getChildren().add(new ProdTreeNode("lenovo 2",lenovo,false));
		
		treeMap.put(ELEC, elec);
		treeMap.put(BOOK,book);
		treeMap.put(COMPUTER, computer);
		treeMap.put(CAMERA, camera);
		treeMap.put(CELLPHONE, cellphone);
		treeMap.put(LAPTOP, loptop);
		treeMap.put(TABLET, tablet);
		treeMap.put(MACBOOKS, macbook);
		treeMap.put(LENOVO, lenovo);
		treeMap.put(DELL, dell);
		treeMap.put(TV, tv);
		treeMap.put(THREE_D, thrd);
		treeMap.put(LED_TV, ledTV);
		treeMap.put(SMART_TV, smartTV);
		treeMap.put("dellbook 1",dellbook1);
		treeMap.put("dellbook 2",dellbook2);
		
		return root;
		
	}


}


/**
 * 
 * basic structure.
 *
 */
class ProdTreeNode{
	
	String name;
	String price;
	String decription;
	
	boolean isCategory = true;
	
	ProdTreeNode parent;
	
	Set<ProdTreeNode> children = new HashSet<ProdTreeNode>();
	
	public ProdTreeNode(String name) {
		this(name,true);
	}
	public ProdTreeNode(String name, ProdTreeNode parent) {
		this(name, parent, true);
	}
	
	public ProdTreeNode(String name,  boolean isCategory) {
		this(name, null ,isCategory);
	}
	
	public ProdTreeNode(String name, ProdTreeNode parent, boolean isCategory) {
		this.name = name;
		this.parent = parent;
		this.isCategory = isCategory;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ProdTreeNode> getChildren() {
		return children;
	}

	public void setChildren(Set<ProdTreeNode> children) {
		this.children = children;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getDecription() {
		return decription;
	}


	public void setDecription(String decription) {
		this.decription = decription;
	}


	public boolean isCategory() {
		return isCategory;
	}


	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}

	public ProdTreeNode getParent() {
		return parent;
	}

	public void setParent(ProdTreeNode parent) {
		this.parent = parent;
	}
	
}