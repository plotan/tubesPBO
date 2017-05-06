package eparking.entity;

public class entityUser {

	String nama,username,password,hakakses;
	int id;


		public String getNama() {
        	return nama;
    	}

    	public void setNama(String nama) {
    		this.nama = nama;
    	}
	
		public String getHakakses() {
	        return hakakses;
	    }

		public void setHakakses(String hakakses) {
			this.hakakses = hakakses;
		}	    

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    
	    
}
