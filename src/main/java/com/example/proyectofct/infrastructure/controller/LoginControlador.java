//package com.example.proyectofct.infrastructure.controller;
//
//import com.example.proyectofct.security.entity.AuthenticationReq;
//import com.example.proyectofct.security.entity.TokenInfo;
//import com.example.proyectofct.security.service.JwtUtilService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoginControlador {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    UserDetailsService usuarioDetailsService;
//
//    @Autowired
//    private JwtUtilService jwtUtilService;
//
//    @RequestMapping("/login")
//    public ResponseEntity<TokenInfo> usuarioLogueado(@RequestBody AuthenticationReq authenticationReq){
//
//        String usuario = authenticationReq.getUsuario();
//        String password = authenticationReq.getClave();
//
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
//
//        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(usuario);
//
//        final String jwt = jwtUtilService.generateToken(userDetails);
//
//        TokenInfo tokenInfo = new TokenInfo(jwt);
//
//        return ResponseEntity.ok(tokenInfo);
//
//    }
//
//}
