package util;

public class Pagination {
	private Integer ye;
	private int maxYe;
	private int beginYe;
	private int endYe;
	private int begin;
	//numInPage һҳ��ʾ��������¼    numOfPage ��ʾ����ҳ��
	public Pagination(Integer ye,int count,int numInPage,int numOfPage) {
		if(count!=0) {
			
		
		this.ye = ye;
		if(this.ye<=1) {
			this.ye=1;
		}
		maxYe=count % numInPage==0?count/numInPage:count/numInPage +1;
		if(this.ye>=maxYe) {
			this.ye=maxYe;
		}
		
		beginYe=this.ye-numOfPage/2;
		if(beginYe<=0) {
			beginYe=1;
		}
			endYe=beginYe+numOfPage-1;
		if(endYe>=maxYe) {
			endYe=maxYe;
	     beginYe=endYe-numOfPage+1;
		}
		if(beginYe<=0) {
			beginYe=1;
		}

		begin=(ye-1)*numInPage;
		}
	}
	public Integer getYe() {
		return ye;
	}
	public int getMaxYe() {
		return maxYe;
	}
	public int getBeginYe() {
		return beginYe;
	}
	public int getEndYe() {
		return endYe;
	}
	public int getBegin() {
		return begin;
	}
	
	
}
