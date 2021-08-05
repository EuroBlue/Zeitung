import java.util.Arrays;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class MainClass{
	private static String inFile;
	private static String inFile2;
    public static File db = new File("E:\\zt_db.txt");
	static ImageIcon icon=new ImageIcon("src\\icon.png");
    //static ImageIcon icon=new ImageIcon("E:\\icon.png");
	static Object [] yes_no= {"Yes","No"};
	public static void setIcon(JFrame frame)
	{
		frame.setIconImage(icon.getImage());
	}
	  public static void FileChecker() {
	    try {
	      if (db.createNewFile()) {
	        System.out.println("File created: " + db.getName());
	      } else {
	      }
	    } catch (IOException e) {
	      System.out.println("F_Check");
	      e.printStackTrace();
	    }
	  }
	public static void FileWriter(String line, int l) {
		String nichts="";
		FileReader();
		if(l==0)
		{
			if(inFile2!=null)
			{
				if(inFile!=null)
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write(inFile+line+"<\n"+inFile2);
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}
				else
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write(line+"<\n"+inFile2);
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}
			}
			else
			{
				if(inFile!=null)
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write(inFile+line+"<");
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}
				else
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write(line+"<");
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}

			}
		}
		else
			if(inFile!=null)
			{
				if(inFile2!=null)
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write(inFile+"\n"+inFile2+line+"<");
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}
				else
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write(inFile+"<\n"+line+"<");
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}
			}
			else
			{
				if(inFile2!=null)
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write("\n"+inFile2+line+"<");
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}
				else
				{
					try {
						FileWriter Writer = new FileWriter(db);
						Writer.write("\n"+line+"<");
						Writer.close();
					    System.out.println("N_writing");
					    } catch (IOException e) {
					    	System.out.println("F_writing");
					    	e.printStackTrace();
					    }
				}

			}
	}
	public static void FileReWriter(String line,int l)
	{
		FileReader();
		if(l==0)
		{
			if(inFile2!=null)
			{
				try {
					FileWriter Writer = new FileWriter(db);
					Writer.write(line+"<\n"+inFile2);
					Writer.close();
				    System.out.println("N_writing");
				    } catch (IOException e) {
				    	System.out.println("F_writing");
				    	e.printStackTrace();
				    }
			}
			else
			{
				try {
					FileWriter Writer = new FileWriter(db);
					Writer.write(line+"<");
					Writer.close();
				    System.out.println("N_writing");
				    } catch (IOException e) {
				    	System.out.println("F_writing");
				    	e.printStackTrace();
				    }
			}

		}
		else
		{
			try {
				FileWriter Writer = new FileWriter(db);
				Writer.write(inFile+"<\n"+line+"<");
				Writer.close();
			    System.out.println("N_writing");
			    } catch (IOException e) {
			    	System.out.println("F_writing");
			    	e.printStackTrace();
			    }
		}
	}
	  public static void FileReader() {
		String data="";
	    try {
	      Scanner Reader = new Scanner(db);
	      if(Reader.hasNextLine())
	      {
		      data = Reader.nextLine();
		      inFile=data;
		      System.out.println(data);
		      if (Reader.hasNextLine()) {
		    	  data = Reader.nextLine();
		    	  inFile2=data;
		    	  System.out.println(data);
		      }
		      else
		    	  inFile2=null;
		      Reader.close();
	      }
	    } 
	    catch (FileNotFoundException e)
	    {
	      System.out.println("F_read");
	      e.printStackTrace();
	    }
	  }
	  public static void FileToObj()
	  {
		  	String line1="";
		  	String line2="";
			String data="";
			String[] ku_inf=new String[6];
			String[] anz_inf=new String[3];
			Scanner Reader = null;
			int z=0;
			int zz=0;
		    Scanner line;
		    try {
				line = new Scanner(db);
				if(line.hasNextLine())
				{
					line1=line.nextLine();
				    System.out.println(line1+" 1 line");
				    Reader = new Scanner(line1);
				    Reader.useDelimiter("<");
				    while (Reader.hasNext())
			      {
			    	  zz++;
			    	  data = Reader.next();
			    	  System.out.println(data+ "ku_l");
			    	  Reader = new Scanner(data);
				      Reader.useDelimiter("&");
				      while (Reader.hasNext())
				      {
				    	  data = Reader.next();
				    	  ku_inf[z]=data;
				    	  z++;
				    	  System.out.println(data+ "ku_l");
				      }
				      Reader.close();
				      new Kunde(ku_inf[0],ku_inf[1],ku_inf[2],ku_inf[3],ku_inf[4],Float.parseFloat(ku_inf[5]));
				      z=0;
				      Reader = new Scanner(line1);
				      Reader.useDelimiter("<");
				      for(int i=0;i<zz;i++)
				      {
					      Reader.next();
				      }
			      }
				}
				
			
		      if(line.hasNextLine())
		      {
				  line2=line.nextLine();
				  System.out.println(line2+" 2 line");
			      Reader = new Scanner(line2);
			      Reader.useDelimiter("<");
		    	  z=0;
		    	  zz=0;
			      while (Reader.hasNext())
			      {
			    	  zz++;
			    	  data = Reader.next();
			    	  System.out.println(data+"lol wtf");
			    	  Reader = new Scanner(data);
				      Reader.useDelimiter("&");
				      while (Reader.hasNext())
				      {
				    	  data = Reader.next();
				    	  System.out.println(data);
				    	  anz_inf[z]=data;
				    	  z++;
				    	  System.out.println(data);
				      }
				      Reader.close();
				      new Anzeige(Float.valueOf(anz_inf[0]),anz_inf[1],Kunde.zeichenListe[findIDKunde(anz_inf[2])]);
				      z=0;
				      Reader = new Scanner(line2);
				      Reader.useDelimiter("<");
				      for(int i=0;i<zz;i++)
				      {
					      Reader.next();
				      }
			      }
		      }
		      if(Reader!=null)
		      {
			      Reader.close();
		      }
		    } catch (FileNotFoundException e) {
		      System.out.println("F_read");
		      e.printStackTrace();
		    }
	  }
	public static boolean preisCheck(int zeile, Kunde k)
	{
		float a=Anzeige.getMBPreis(zeile);
		float b=k.getGeld();
		if(a<b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int findIDKunde(String v)
	{
		int a=0;
		boolean found=false;
		int i;
		int b=Kunde.getKZ();
		for(i=0;i<b;i++)
		{
			String x=Kunde.getKunde(i);
			if(x.equals(v))
			{
				found=true;
				break;
			}
			else
			{
				a++;
			}
		}
		return a;
	}
	public int findIDPass(String v)
	{
		int a=0;
		boolean found=false;
		int i;
		int b=Kunde.getKZ();
		for(i=0;i<b;i++)
		{
			String x=Kunde.getPass(i);
			if(x.equals(v))
			{
				found=true;
				break;
			}
			else
			{
				a++;
			}
		}
		return a;
	}
	public static void FileUpdate()
	{
		System.out.println(Kunde.zeichenListe.length);
		for(int i=0;i<Kunde.zeichenListe.length;i++)
		{

			FileReWriter(Kunde.zeichenListe[i].getUsername()+"&"+Kunde.zeichenListe[i].getKundPass()+"&"+Kunde.zeichenListe[i].getFName()+"&"+Kunde.zeichenListe[i].getLName()+"&"+Kunde.zeichenListe[i].getTelefon()+"&"+String.valueOf(Kunde.zeichenListe[i].getGeld())+"&",0);
		}
		if(Anzeige.anzeigeListe!=null)
		{
			for(int i=0;i<Anzeige.anzeigeListe.length;i++)
			{
				FileReWriter(String.valueOf(Anzeige.anzeigeListe[i].getZA())+"&"+Anzeige.anzeigeListe[i].getTitel()+"&"+Anzeige.anzeigeListe[i].anzeigeKunde.getUsername(),1);		
			}
		}

	}
	public static void main(String[] args)
	{
		FileChecker();
		FileReader();
		FileToObj();
		Login.start("");
	}
}