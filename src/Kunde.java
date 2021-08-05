public class Kunde extends MainClass {
	private static int kz=0;
	private static String[] kundenListe=new String[kz];
	private static String[] passListe=new String[kz];
	public static Kunde[] zeichenListe=new Kunde[kz];
	private int kn;
	private float geld;
	private String username;
	private String vorname;
	private String nachname;
	private String telefon;
	private String pass;
	private static String[] addList(String a)
	{
		int i=0;
		String newarr[]=new String[kz+1];
		if(kz>0)
		{
			for (i=0; i<kz;i++)
			{
				newarr[i]=kundenListe[i];
			}

		}
		else
		{
			
		}
		newarr[kz]=a;
		return newarr;
	}
	private static String[] removeList(int id)
	{
		int i=0;
		int a=i;
		String newarr[]=new String[kz-1];
		if(kz>0)
		{
			for (a=0,i=0; i<kz;i++,a++)
			{
				if(i!=id)
				{
					newarr[a]=kundenListe[i];
				}
				else
				{
					a--;
				}
			}

		}
		else
		{
			
		}
		return newarr;
	}
	public static void setList(int id,String a)
	{
		kundenListe[id]=a;
	}
	private static String[] addPass(String a)
	{
		int i=0;
		String newarr[]=new String[kz+1];
		if(kz>0)
		{
			for (i=0; i<kz;i++)
			{
				newarr[i]=passListe[i];
			}

		}
		else
		{
			
		}
		newarr[kz]=a;
		return newarr;
	}
	private static String[] removePass(int id)
	{
		int i=0;
		int a=i;
		String newarr[]=new String[kz-1];
		if(kz>0)
		{
			for (a=0,i=0; i<kz;i++,a++)
			{
				if(i!=id)
				{
					newarr[a]=passListe[i];
				}
				else
				{
					a--;
				}
			}

		}
		else
		{
			
		}
		return newarr;
	}
	private static Kunde[] addZeichen(Kunde a)
	{
		int i=0;
		Kunde newarr[]=new Kunde[kz+1];
		if(kz>0)
		{
			for (i=0; i<kz;i++)
			{
				newarr[i]=
						zeichenListe[i];
			}
		}
		else
		{
				
		}
		newarr[kz]=a;
		return newarr;
	}
	private static Kunde[] removeZeichen(int id)
	{
		int i=0;
		int a=i;
		Kunde newarr[]=new Kunde[kz-1];
		if(kz>0)
		{
			for (a=0,i=0; i<kz;i++,a++)
			{
				if(i!=id)
				{
					newarr[a]=zeichenListe[i];
				}
				else
				{
					a--;
				}
			}

		}
		else
		{
			
		}
		return newarr;
	}
	public static void deleteAcc(int id)
	{
		kundenListe=removeList(id);
		passListe=removePass(id);
		zeichenListe=removeZeichen(id);
		kz=kz-1;
	}
	public static String[] getKL()
	{
		return kundenListe;
	}
	public static String[] getPL()
	{
		return passListe;
	}
	public static String getPass(int a)
	{
		String pass=passListe[a];
		return pass;
	}
	public static String getKunde(int a)
	{
		String kunden=kundenListe[a];
		return kunden;
	}
	public static Kunde getZeichen(int a)
	{
		Kunde zeichen=zeichenListe[a];
		return zeichen;
	}
	public void setUsername(String user) {
		username=user;
	}
	public void setVorname(String kVorname) {
		vorname=kVorname;
	}
	public void setNachname(String kNachname) {
		nachname=kNachname;
	}
	public void setTelefon(String kTelefon) {
		telefon=kTelefon;
	}
	public void setKN() {
		kn=kz;
	}
	public void setGeld(float kGeld)
	{
		geld=kGeld;
	}
	public void setPass(String kPass)
	{
		pass=kPass;
	}
	public void editPass(String newPass, String oldPass)
	{
		int a=findIDPass(oldPass);
		setPass(newPass);
		passListe[a]=newPass;
	}
	public String getUsername() {
		return username;
	}
	public String getVorname() {
		return vorname;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getNachname() {
		return nachname;
	}
	public String getName()
	{
		String name=vorname+" "+nachname;
		return name;
	}
	public String getFName()
	{
		return vorname;
	}
	public String getLName()
	{
		return nachname;
	}
	public int getKN()
	{
		return kn;
	}
	public static int getKZ()
	{
		return kz;
	}
	public float getGeld()
	{
		return geld;
	}
	public String getKundPass()
	{
		return pass;
	}
	public Kunde(String k,String password,String fn,String ln,String telefon,float geld)
	{
		
		kundenListe=addList(k);
		passListe=addPass(password);
		zeichenListe=addZeichen(this);
		this.setUsername(k);
		this.setVorname(fn);
		this.setNachname(ln);
		this.setTelefon(telefon);
		this.setGeld(geld);
		this.setPass(password);
		kz=kz+1;
		kn=kz;
	}
}