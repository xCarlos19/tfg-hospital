import { Box, Flex, Heading, Button, Stack, Text, Textarea, Image, Tag } from "@chakra-ui/react";
import { AddIcon, DownloadIcon } from "@chakra-ui/icons";
import { useEffect, useState } from "react";
import * as API from "../../services/recetas-service";
import { Navigate, useNavigate } from "react-router-dom";


export function ListRecetas() {
  let navigate = useNavigate();
  const routeForm = () => {
    navigate("/recetas/insertar")
  }
  const [recetas, setRecetas] = useState([]);

  useEffect(() => {

    API.getRecetasByUsername().then(setRecetas);

  }, [])



  return (
    <>
      
      <Box w={'80%'} h={'100%'} m={'auto'}  >
        
        <Flex alignItems={'center'} justifyContent={'center'} direction={"column"}>
          <Heading as={"h1"} fontFamily={"Roboto Slab"} marginTop={"50px"} textAlign={'center'} fontSize={'72px'}> Recetas </Heading>
          <Text fontFamily={"serif"} fontSize={"20px"}>Hospital General Universitari València</Text>
        </Flex>
        <Flex alignItems={'center'} justifyContent={'flex-end'}  marginRight={"150px"}>
          <Button colorScheme={'blue'} m={'15px'} fontSize={'18px'} onClick={routeForm} > <AddIcon m={'5px'} />Nueva receta</Button>
        </Flex>

        {
          recetas.map(receta => (
            <>
              {console.log(receta)}
              <Box borderRadius={"20px"} border={"2px solid green"} w={"80%"} h={"250px"} m={"auto"} marginBottom={"50px"} backgroundColor="whatsapp.50" >
                <Stack direction="row" alignItems="center">
                  <Flex m={"15px"} w={"100%"} direction={"row"} justifyContent={"space-between"}>
                    <Flex direction={"column"}>

                      <Text fontWeight="semibold">{receta.fechaCreacion}</Text>
                      <Text fontWeight="semibold">Colegiado: {receta.nombreSanitario}</Text>


                    </Flex>
                    <Heading fontWeight="semibold">{receta.nombrePaciente}</Heading>
                    <Image w={"200px"} src="https://svreumatologia.es/wp-content/uploads/2021/06/svr-logos-consorci-hospital-general-universitari-valencia-02.png" />
                  </Flex>
                </Stack>

                <Stack direction="row" alignItems="center" marginTop={"10px"} >
                  <Flex p={"10px"} width={"70%"} margin={"auto"}>
                    <Box marginLeft={"15px"}>
                      <Text >Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam sequi, et consequuntur repellat nostrum in impedit natus possimus odio doloribus iure magnam excepturi temporibus tempora architecto ullam! Dolores, eaque incidunt?</Text>
                    </Box>

                  </Flex>
                </Stack>
                <Stack>
                  <Flex justifyContent={"space-between"} paddingRight={"20px"} paddingLeft={"20px"} >
                    <Flex >{

                      receta.medicamentos.map(med => (

                        <Tag m={"5px"} backgroundColor={"whatsapp.300"}>{med}</Tag>

                      ))

                    }

                    </Flex>

                    <Button colorScheme={"telegram"}>Descargar<DownloadIcon marginLeft={"5px"}></DownloadIcon></Button>

                  </Flex>


                </Stack>


                </Box>
             
            </>
          ))
        }



        <Box h={"50px"}></Box>

      </Box>
    </>

  )



}


function isLoged() {
  try {
    const token = JSON.parse(localStorage.getItem("user")).token;
    if (token) {
      return true;
    }

  } catch (e) {
    return false;
  }
}

function isAllowed() {

  if (isLoged()) {
    const roles = JSON.parse(localStorage.getItem("user")).roles;

    if (roles.includes("ENFERMERIA")) {
      return true;
    }
  }

}