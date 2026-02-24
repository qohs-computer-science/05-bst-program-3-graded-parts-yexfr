public class TreeNode
{
	private TreeNode left;
	private TreeNode right;
	private Comparable data;
	
	public TreeNode(Comparable initValue)
	{
		data = initValue;
		left = null;
		right = null;
	}

	public TreeNode(Comparable initValue, TreeNode initLeft, TreeNode initRight)
	{
		data = initValue;
		left = initLeft;
		right = initRight;
	}
	
	public Comparable getData()
	{
		return data;
	}

	public TreeNode getLeft()
	{
		return left;
	}

	public TreeNode getRight()
	{
		return right;
	}
	
	public void setData(Comparable newValue)
	{
		value = newValue;
	}

	public void setLeft(TreeNode newLeft)
	{
		left = newLeft;
	}
	
	public void setRight(TreeNode newRight)
	{
		right = newRight;
	}
	
}