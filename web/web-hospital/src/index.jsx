import React from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import { App } from './App';
import reportWebVitals from './reportWebVitals';
import { ChakraProvider } from '@chakra-ui/react'
import { BrowserRouter, Routes, Route, } from 'react-router-dom'
import { ListMedicamentos } from './components/Medicamentos/ListMedicamentos';
import { FormMedicamento } from './components/Medicamentos/FormMedicamento';
import { ListRecetas } from './components/Recetas/ListRecetas';
import { FormReceta } from './components/Recetas/FormReceta';
import { MedicamentoDetails } from './components/Medicamentos/MedicamentoDetails';

const container = document.getElementById('root');
const root = createRoot(container)
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <ChakraProvider>
        <Routes>
          <Route path="/" element={<App />} />
          <Route path="medicamentos" element={<ListMedicamentos />} />
          <Route path="recetas" element={<ListRecetas />} />
          <Route path="recetas/insertar" element={<FormReceta />} />
          <Route path="/medicamentos/insertar" element={<FormMedicamento />} />
          <Route path="/medicamentos/:id" element={<MedicamentoDetails />} />
        </Routes>
      </ChakraProvider>
    </BrowserRouter>

  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
