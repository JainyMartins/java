package dio.springsecurityjwt.security;

import io.jsonwebtoken.*;

import java.util.List;
import java.util.stream.Collectors;

public class JWTCreator {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    //Pega prefixo, chave e objeto que será gerado por alguém no BD
    //E vamos GERAR TOKEN - vai precisar de subject, data de criação, de expiração, roles e algoritmo de criptografia
    public static String create(String prefix, String key, JWTObject jwtObject){
        String token = Jwts.builder().setSubject(jwtObject.getSubject()).setIssuedAt(jwtObject.getIssuedAt()).setExpiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles())).signWith(SignatureAlgorithm.HS512, key).compact();
        //Monta token com prefixo para usar nas requisições
        return prefix + " " + token;
    }

    //Pega TOKEN nas requisições (provavelmente nosso filtro), verificar prefixo e chave que foi criptografado para comparar com nossa chave - verifica integridade
    public static JWTObject create(String token, String prefix, String key)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        //Cria objeto passando características para que nosso filtro venha validar parte estrutural
        JWTObject object = new JWTObject();
        token = token.replace(prefix, "");
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        //Aqui faz parse pra uma lista de roles
        object.setRoles((List) claims.get(ROLES_AUTHORITIES));
        return object;
    }

    private static List<String> checkRoles(List<String> roles){
        return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_", ""))).collect(Collectors.toList());
    }
}
