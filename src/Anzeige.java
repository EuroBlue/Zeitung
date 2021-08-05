public class Anzeige extends MainClass {
	private static float steuer=1.15f;
	private static int gp=20;
	private static int zeilentarif=5;
	private float zeilenanzahl;
	private static int az;
	private String titel;
	public Kunde anzeigeKunde;
	public static Anzeige[] anzeigeListe;
	public float getPreis()
	{
		float preis=(gp+(zeilenanzahl*zeilentarif))*steuer;
		return preis;
	}
	public float getZA()
	{
		return zeilenanzahl;
	}
	public String getTitel()
	{
		return titel;
	}
	public Kunde getAnzKunde()
	{
		return anzeigeKunde;
	}
	public static float getMBPreis(float zv)
	{
		float preis=(gp+(zv*zeilentarif))*steuer;
		return preis;
	}
	public String getInfo()
	{
		return titel+" "+anzeigeKunde.getName()+" "+zeilenanzahl +" "+getPreis(); 
	}
	public void setZeileA(int zv)
	{
		zeilenanzahl=zv;
	}
	public void setTitel(String tv)
	{
		titel=tv;
	}
	private static Anzeige[] addAnzeige(Anzeige a)
	{
		int i=0;
		Anzeige newarr[]=new Anzeige[az+1];
		if(az>0)
		{
			for (i=0; i<az;i++)
			{
				newarr[i]=anzeigeListe[i];
			}
		}
		else
		{
				
		}
		newarr[az]=a;
		return newarr;
	}
	public static String[] createPersAnzeigeList(Kunde k)
	{
		int i=0;
		int a=0;
		int b=az;
		int d=0;
		Anzeige newarr[]=new Anzeige[az];
		String newnewarr[]=new String[0];
		if(az>0)
		{
			for (a=0, i=0; i<az;i++,a++)
			{
				if(anzeigeListe[i]!=null)
				{
					if(anzeigeListe[i].getAnzKunde()==k)
					{
						newarr[a]=anzeigeListe[i];
					}
					else
					{
						a--;
					}
				}
				else
				{
					a--;
				}
			}
			for(b=az;b>0;b--)
			{
				if(newarr[b-1]!=null)
				{
					d++;
				}
			}
			newnewarr=new String[d];
			for (i=0; i<d;i++)
			{
				newnewarr[i]=anzeigeListe[i].getTitel();
			}
		}
		else
		{
				
		}
		return newnewarr;
	}
	public static Anzeige[] createPersAnzeigeNonStrList(Kunde k)
	{
		int i=0;
		int a=0;
		int b=az;
		int d=0;
		Anzeige newarr[]=new Anzeige[az];
		Anzeige newnewarr[]=new Anzeige[0];
		if(az>0)
		{
			for (a=0, i=0; i<az;i++,a++)
			{
				if(anzeigeListe[i]!=null)
				{
					if(anzeigeListe[i].getAnzKunde()==k)
					{
						newarr[a]=anzeigeListe[i];
					}
					else
					{
						a--;
					}
				}
				else
				{
					a--;
				}
			}
			for(b=az;b>0;b--)
			{
				if(newarr[b-1]!=null)
				{
					d++;
				}
			}
			newnewarr=new Anzeige[d];
			for (i=0; i<d;i++)
			{
				newnewarr[i]=anzeigeListe[i];
			}
		}
		else
		{
				
		}
		return newnewarr;
	}
	public static void deleteAdver(int id)
	{
		Anzeige.anzeigeListe=Anzeige.deleteAnzeigeFromList(id);
		az=az-1;
	}
	public static Anzeige[] deleteAnzeigeFromList(int id)
	{
		Anzeige newarr[]=new Anzeige[az-1];
		anzeigeListe[id]=null;
		int i=0;
		int a=0;
		for(a=0, i=0; i<az;i++,a++)
		{
			if(anzeigeListe[i]!=null)
			{
				newarr[a]=anzeigeListe[i];
			}
			else
			{
				a--;
			}
		}
		return newarr;

	}
	public Anzeige(float zv, String tv, Kunde kv)
	{
		anzeigeKunde=kv;
		zeilenanzahl=zv;
		titel=tv;
		anzeigeListe=addAnzeige(this);
		az=az+1;
	}
}
