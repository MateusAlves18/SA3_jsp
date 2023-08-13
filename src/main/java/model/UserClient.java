package model;

public class UserClient {
	public UserClient(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserClient(String email, String name, String matricula, String endereco, String password, String isCNPJ) {
		super();
		this.email = email;
		this.name = name;
		this.matricula = matricula;
		this.endereco = endereco;
		this.password = password;
		this.isCNPJ = isCNPJ;
	}

	private String email;
	private String name;
	private String matricula;
	private String endereco;
	private String password;
	private String isCNPJ;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getIsCNPJ() {
		return isCNPJ;
	}

	public void setIsCNPJ(String isCNPJ) {
		this.isCNPJ = isCNPJ;
	}

}
