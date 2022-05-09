import {
    Box, Button, Container, Flex, Modal, ModalBody,
    ModalCloseButton, ModalContent, ModalFooter, ModalHeader, ModalOverlay, Text, Input, FormControl, FormLabel, useDisclosure, Textarea
} from "@chakra-ui/react";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import swal from "sweetalert";
import * as API from "../../services/medicamentos-service";



export const MedicamentoDetails = () =>{
    const[medicamento, setMedicamento] = useState("");
    const params = useParams();
    const navigate = useNavigate();
    const { isOpen, onOpen, onClose } = useDisclosure()
    useEffect(()=>{

        API.getMedicamentoById(params.id).then(data =>{
            setMedicamento(data); 
            setMedicamentoMod(data)
        });

    }, [])
    const[medicamentoMod, setMedicamentoMod] = useState({
        "nombre": "",
        "descripcion": "",
        "fabricante": ""
    })
    const deleteMedicamento  = (med) =>{
        swal({
            icon: "warning",
            text: "Estás seguro que deseas eliminar " + med.nombre,
            buttons: ["No", "Sí"]
          }).then(respuesta => {
            if (respuesta) {
              API.deleteMedicamento(med.id);
              
              swal({
                icon: "success",
                title: "Eliminado " + med.nombre
              }).then(navigate("/medicamentos"));
            }
          })
    }
    const handleNombreChange = (e) =>{
        setMedicamentoMod({...medicamentoMod,  nombre: e.target.value})
    }
    const handleDescripcionChange = (e) =>{
        setMedicamentoMod({...medicamentoMod,  descripcion: e.target.value})
    }
    const handleFabricanteChange = (e) =>{
        setMedicamentoMod({...medicamentoMod,  fabricante: e.target.value})
    }
    const handleSubmit = (e) =>{
        e.preventDefault()
        console.log(medicamentoMod)
        swal({
            icon: "warning",
            text: "Estás seguro que deseas eliminar modificar este medicamento ",
            buttons: ["No", "Sí"]
          }).then(respuesta => {
            if (respuesta) {
              API.putMedicamento(medicamentoMod).then(data => {
                swal({
                    icon: "success",
                    title: "Modificado "+data.nombre
                  }).then(navigate("/medicamentos"));
              })
              
              
            }
          })
    }
    return(<>
        <Container minH={"100vh"} display={"flex"} alignItems={"center"} justifyContent="center">
        <Box w={"500px"} h={"600px"} boxShadow={"outline"} display={"flex"} flexDirection={"column"} justifyContent="space-evenly">
            <Flex direction={"column"}>
                
            <Text textAlign={"center"} fontSize="48px" fontWeight={"semibold"}>{medicamento.nombre}</Text>
            <Text textAlign={"center"} fontSize="24px">{medicamento.fabricante}</Text>

            </Flex>
            <Text textAlign={"center"} fontSize="24px">{medicamento.descripcion}</Text>
            
            <Box w={"100%"} display="flex" justifyContent={"center"} gap={"10px"}>
            <Button colorScheme={"green"} onClick={onOpen}>Editar</Button>
            <Button colorScheme={"red"} onClick={(e) => {
                deleteMedicamento(medicamento,e)
            }}>Eliminar</Button>
            </Box>
        </Box>
        </Container>
         /** Modal */
        <Modal
        
        isOpen={isOpen}
        onClose={onClose}
        
        >
        <ModalOverlay />
        <form onSubmit={handleSubmit}>
        <ModalContent>
          <ModalHeader>Modifica los campos</ModalHeader>
          <ModalCloseButton />
          <ModalBody pb={6}>
              
            <FormControl>
              <FormLabel>Nombre</FormLabel>
              <Input onChange={handleNombreChange} placeholder={medicamentoMod.nombre} />
            </FormControl>

            <FormControl mt={4}>
              <FormLabel>Descripcion</FormLabel>
              <Textarea onChange={handleDescripcionChange} resize={"none"} placeholder={medicamentoMod.descripcion} />
            </FormControl>

            <FormControl mt={4}>
              <FormLabel>Fabricante</FormLabel>
              <Input onChange={handleFabricanteChange} placeholder={medicamentoMod.fabricante} />
            </FormControl>
          </ModalBody>

          <ModalFooter>
            <Button colorScheme='green' mr={3} type={"submit"}>
              Save
            </Button>
            <Button onClick={onClose}>Cancel</Button>
          </ModalFooter>
        </ModalContent>
        </form>
      </Modal>
    </>)
}

