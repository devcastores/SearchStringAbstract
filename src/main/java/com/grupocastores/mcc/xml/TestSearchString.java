package com.grupocastores.mcc.xml;
public class TestSearchString {

  public static void main(String[] args) {

	  char array[] = {'i','s','h'};
	  char array_isma[] = {'i','s','m','a'};
	  
	  SearchText sh = new SearchText();
	  SearchText sh_isma = new SearchText();
	  
	  sh.setText("i.s.h.");
	  sh.setArray(array);
	  
	  sh_isma.setText("isma");
	  sh_isma.setArray(array_isma);
      
	  System.out.println(sh.SearchString());
	  System.out.println(sh_isma.SearchString());

  }

}