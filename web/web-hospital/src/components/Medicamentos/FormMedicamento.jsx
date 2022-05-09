import { FormControl, FormLabel, Input, Center, Button, Textarea } from "@chakra-ui/react"
import { useState } from "react"
import { useNavigate } from "react-router-dom"
import { postMedicamento } from "../../services/medicamentos-service"

export  const FormMedicamento = () => {
    let navigate = useNavigate()
    const[medicamento, setMedicamento] = useState({
        nombre: "",
        descripcion:"",
        fabricante:""

    })
    

    const handleNombreChange = (e)=>{
        setMedicamento({...medicamento, nombre:e.target.value});
    }

    const handleDescripcionChange = (e)=>{
        setMedicamento({...medicamento, descripcion:e.target.value});
    }
    const handleFabricanteChange = (e)=>{
        setMedicamento({...medicamento, fabricante:e.target.value});
    }
    ;
    const handleSubmit = (e)=>{
        e.preventDefault()

        postMedicamento(medicamento).then(data =>{
           navigate("/medicamentos");
        })
    }

    return (
        <form onSubmit={handleSubmit}>
        <FormControl>

            <FormLabel fontSize={'24px'} htmlFor='nombre'> Nombre </FormLabel>
            <Input variant='flushed' value={medicamento.nombre} onChange={handleNombreChange} id='nombre' focusBorderColor='red.500' type={'text'} placeholder="Introduce tu usuario" ></Input>

        </FormControl>

        <FormControl>
            <FormLabel fontSize={'24px'} htmlFor='descripcion' marginTop={10}> Descripcion </FormLabel>
            <Textarea variant='flushed' value={medicamento.descripcion} onChange={handleDescripcionChange} focusBorderColor='red.500' id='descripcion' type={'password'}></Textarea>
            
        </FormControl>
        <FormControl>
            <FormLabel fontSize={'24px'} htmlFor='cantidad' marginTop={10}> Fabricante </FormLabel>
            <Input variant='flushed' value={medicamento.fabricante} onChange={handleFabricanteChange} focusBorderColor='red.500' id='fabricante' type={'text'}></Input>
            
        </FormControl>
        <Center>
        <Button marginTop={10} alignSelf={'center'} colorScheme='red' color={'white'} type="submit" > Enviar</Button>
        </Center>
    </form>
    )
}