import { FormControl, FormLabel, Heading, Input, Flex, Box, Button, Center } from '@chakra-ui/react'
import { useEffect, useState } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import { login } from '../../services/login-service';
import { Image } from '@chakra-ui/react';

export const FormLogin = () => {
    let navigate = useNavigate();
    
    const[datosLogin, setdatosLogin] = useState({
        username:"",
        password:""
    });
    
    
   const handleUsernameChange = (e)=>{
       setdatosLogin({...datosLogin, username : e.target.value});
       
   }
   const handlePasswordChange = (e)=>{
    setdatosLogin({...datosLogin, password : e.target.value});
    
}
    const getSubmit =  (e) => {
        e.preventDefault()

        login(datosLogin).then(data => {localStorage.setItem("user", JSON.stringify(data));
        
        const roles = JSON.parse(localStorage.getItem("user")).roles;

        console.log(roles);

        if(roles.includes("ENFERMERIA")){

            navigate("/medicamentos");
        }
        if(roles.includes("MEDICINA")){
            navigate("/recetas")
        }

    })
        
    }
    return (
        <>
        <Box minH={"80vh"} display={"flex"} direction={"row"} alignItems={"center"}>
            
            <Flex w={"100%"} fontFamily={'sans-serif'} direction={'column'} alignItems={'center'} >

                <Image  w={"400px"} src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Imagotip_de_la_Generalitat_Valenciana.svg/1200px-Imagotip_de_la_Generalitat_Valenciana.svg.png"></Image>
                
                <Box margin={10} w='25%' >
                    <form onSubmit={getSubmit}>
                        <FormControl>

                            <FormLabel fontSize={'24px'} htmlFor='username'> Nombre de usuario </FormLabel>
                            <Input p={"5px"} variant='flushed' value={datosLogin.username} onChange={handleUsernameChange} id='username' focusBorderColor='red.500' type={'text'} placeholder="Introduce tu usuario" required></Input>

                        </FormControl>

                        <FormControl>
                            <FormLabel fontSize={'24px'} htmlFor='password' marginTop={10}> Contraseña </FormLabel>
                            <Input variant='flushed' value={datosLogin.password} onChange={handlePasswordChange} focusBorderColor='red.500' id='password' type={'password'} placeholder="Introduce tu contraseña" required></Input>
                            
                        </FormControl>
                        <Center>
                        <Button marginTop={10} alignSelf={'center'} colorScheme={"red"} color={'white'} type="submit" > Entrar</Button>
                        </Center>
                    </form>
                </Box>

                
            </Flex>
            </Box>

        </>
    )
}