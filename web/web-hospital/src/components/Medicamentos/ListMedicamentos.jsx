import { AddIcon } from '@chakra-ui/icons';
import { Box, Button, Flex, Heading, Table, TableContainer, Tbody, Td, Th, Thead, Tr, Text, Icon } from "@chakra-ui/react";
import { useEffect, useState } from "react";
import { Link, Navigate, useNavigate } from "react-router-dom";
import swal from 'sweetalert';
import * as API from "../../services/medicamentos-service";



export const ListMedicamentos = () => {


  let navigate = useNavigate();
  
  
  function desconectar(){
    
    localStorage.clear();
    navigate("/")
  
  }

  const [medicamentos, setMedicamentos] = useState([]);

  useEffect(() => {
    API.getAllMedicamentos().then(setMedicamentos);
  }, []);

  

  return (
    <>
      {!isAllowed() && (<Navigate to="/" />)}
      <Box w={'75%'} m={'auto'}>
        <Flex alignItems={'center'} justifyContent={'center'} >
          <Heading flexGrow={"2"} as={'h1'} m={10} textAlign={'center'} fontSize={'54px'}> Medicamentos </Heading>
          <Flex justifyContent={"flex-end"} >
            <Button colorScheme={"red"} onClick={desconectar} ><Icon viewBox='0 0 16 16' boxSize={"20px"}>

              <path
                fill="currentColor"
                fillRule="evenodd"
                d="M8 2H3.4l3.3 3.3c.2.2.3.4.3.7v9c0 .4-.2.8-.6.9-.1.1-.3.1-.4.1-.3 0-.5-.1-.7-.3l-5-5c-.2-.2-.3-.4-.3-.7V1c0-.6.4-1 1-1h8c.6 0 1 .4 1 1v3H8V2zM2 9.6l3 3V6.4l-3-3v6.2zm10-6l3.7 3.7c.4.4.4 1 0 1.4L12 12.4 10.6 11l2-2H8V7h4.6l-2-2L12 3.6z"
                clipRule="evenodd"
              />

            </Icon></Button>
          </Flex>

        </Flex>
        <Flex alignItems={'center'} justifyContent={'flex-end'}>

        </Flex>
        <Flex alignItems={'center'} justifyContent={'flex-end'}>
          <Link to={"/medicamentos/insertar"}>
          <Button colorScheme={'blue'} m={'15px'} fontSize={'18px'}> <AddIcon m={'5px'} />Nuevo medicamento</Button>
          </Link>
        </Flex>




        <TableContainer w={'80%'} margin={'auto'} textAlign={"justify"}>
          <Table variant={"simple"} >

            <Thead >
              <Tr  >
                <Th textAlign={'center'} fontSize={'24px'}>Nombre</Th>
                <Th textAlign={'center'} fontSize={'24px'}>Descripcion</Th>
                <Th textAlign={'center'} fontSize={'24px'}>Fabricante</Th>
                <Td></Td>
              </Tr>
            </Thead>

            <Tbody>

              {medicamentos.map(med => (

                <Tr key={med.id}>
                  <Td textAlign={'center'}>{med.nombre}</Td>
                  <Td textAlign={'center'}>{med.descripcion}</Td>
                  <Td textAlign={'center'}>{med.fabricante}</Td>
                  <Td>
                    <Link to={`/medicamentos/${med.id}`}>
                      <Button colorScheme={'green'} m={2} >Detalles</Button>
                    </Link>
                  </Td>
                </Tr>
              ))}

            </Tbody>

          </Table>


        </TableContainer>


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





/* const deleteMedicamento = (med) => {


    
  } */


