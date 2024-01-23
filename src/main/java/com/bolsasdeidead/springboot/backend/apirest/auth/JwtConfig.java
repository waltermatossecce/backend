package com.bolsasdeidead.springboot.backend.apirest.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA="alguna.clave.secreta.12345678";
    
	public static final String RSA_PRIVADA="-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEArpO9Mutcbt9tfwANl2bJT2rwJMIWNRmUfCoGrPM8zPoc3ZNq\r\n"
			+ "lIoaTbQlL/4Kewrp5/twS+EVzHj6C5GWLiU36EoDhe42EcEjluO4OyEocPSA2oPa\r\n"
			+ "pK4l/E4mKbpZ2nyxPHySreA2rpze/9oX9RYMBGk+waDYsGy+euDHshm68AENzaN8\r\n"
			+ "CXVC/BONIZDON7QNJB+ZGVOM85x8QAEBYNCWehqDTcwgfwR3dAS/bTaIAF1/J6GU\r\n"
			+ "zgvwlTKBAk5mSEREHzkReDDhLlSCXcD+WIbOYTL2MxI8TWZASZKf+yBvL2OC6HBJ\r\n"
			+ "ggjVQbQoqAYK8gMiruIcD+jIRK/XZ/5wXIVuEQIDAQABAoIBAEUtwkGVRrGg1BEJ\r\n"
			+ "gllGn+taowLN7mLoWhDBzpdmY+eODTY4nnlyKG42Pq4/6wNLFdmZp6xJ64t1PRCs\r\n"
			+ "hmiO0xK3kaHW/ZIXiPTYFD9KKm5oVU9CBLhRUjgi97h9YfHUi58+dhl0yfZzr2KP\r\n"
			+ "mALE08pDslykUnnG/cxPmpKW458LA5KVuLbVkAmzDYB4pg+fcVVAodTN4bMgg49T\r\n"
			+ "iPV618MusxqjvwqOma3+L/3iISi+eAsaoE8xLCPWOIBa0pmq4q1EVTsnX01zrpYR\r\n"
			+ "W3bQYpIvDyiYTaCLRjjBI121z1erS0dOw0aBByUm6wqtqQIoDqmZk82V4t0np+0j\r\n"
			+ "tqCwzYkCgYEA6GsdcnkhG3UFmFbuDUwu270TXPQ4yRpVBowbjYv9S9MF4FD2H2UI\r\n"
			+ "5FvAitXay28lItSsdmyUO4pX29O+A/dKvKC10F/BYAYEesPNyh/0908Jt2yNY2Xl\r\n"
			+ "X3vOEVKtUy1GiPGzWKjsJcRQbJXwzliWGq+swXzgJY+55D1B/GwxxEcCgYEAwEo9\r\n"
			+ "2QUUHH6Q+Hui08PRrY+kNSbSlU+vh151zaSkypBOH3maqkX9gRvbGsiV7NdAb6EZ\r\n"
			+ "88Ix3QO7v5gqHNXrHTqBanZzYkaLufxUJcSliqFLyt/Cb1dvxxNKFg16S4bUI8D5\r\n"
			+ "hPl7LugMI4T+vrNmXAaecOFdXc/tAh9xZmP7HucCgYANeQAY/aqMo+jyHr/n522j\r\n"
			+ "8T7pGYMdLTiWi5KhTucc+RuTGD5cLYgpbKQpqCHpvwShE0D4EG07UlareIfARRqA\r\n"
			+ "+rPvY02bWl3yG92XBOk3WM6QYmuDwolcUpnsaSWA99Pp5lDmJ8ygl9Otp7dwzrPM\r\n"
			+ "0jgqcymvI7i74U0s67yqywKBgQCW6q3X4jCCnKNTIlYNNicevRn3zVyBa2UsLWrv\r\n"
			+ "10Su5ssp0NsewIfSCPbR8pQYqmgcNKiVs9hGymNUYCzNLOe2rPBdilHM0+leMzgn\r\n"
			+ "3ErAnw9JTozfrhRAflcrL7DIDi35Ub+EKfoQOncseXkmWs7/cwJvPbF1q3csr1jl\r\n"
			+ "L5ssCQKBgQDHS1m3YakBDvfc6r7PDBq3it3kdH8Qun8274/6fp1vGDIyarMxhw4Z\r\n"
			+ "z265Zdfs11LTpfTNltBsJQaO1Z6fSfUgob3PTf+PGn2oF9OGx/QQEncLAyEjGGBx\r\n"
			+ "zlTFcXo2Wepf5mqcsrA5Snc1f3BYv/IpyuKqKSEE8/gHyW46dkXfpQ==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
    
    public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\r\n"
    		+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArpO9Mutcbt9tfwANl2bJ\r\n"
    		+ "T2rwJMIWNRmUfCoGrPM8zPoc3ZNqlIoaTbQlL/4Kewrp5/twS+EVzHj6C5GWLiU3\r\n"
    		+ "6EoDhe42EcEjluO4OyEocPSA2oPapK4l/E4mKbpZ2nyxPHySreA2rpze/9oX9RYM\r\n"
    		+ "BGk+waDYsGy+euDHshm68AENzaN8CXVC/BONIZDON7QNJB+ZGVOM85x8QAEBYNCW\r\n"
    		+ "ehqDTcwgfwR3dAS/bTaIAF1/J6GUzgvwlTKBAk5mSEREHzkReDDhLlSCXcD+WIbO\r\n"
    		+ "YTL2MxI8TWZASZKf+yBvL2OC6HBJggjVQbQoqAYK8gMiruIcD+jIRK/XZ/5wXIVu\r\n"
    		+ "EQIDAQAB\r\n"
    		+ "-----END PUBLIC KEY-----";
    
	
}
