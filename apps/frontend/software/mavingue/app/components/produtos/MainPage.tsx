'use client'
import { useState } from 'react';
import CatalogoProdutos from './CatalogoProdutos';
import HeroIntro from './HeroIntro';


const Card = ({ children, className = "" }) => (
  <div className={`bg-white rounded-xl shadow-sm border border-gray-100 p-6 ${className}`}>
    {children}
  </div>
);

const Badge = ({ children, type = "success" }) => {
  const styles = {
    success: "bg-green-100 text-green-700",
    danger: "bg-red-100 text-red-700",
    warning: "bg-yellow-100 text-yellow-700"
  };
  return (
    <span className={`px-3 py-1 rounded-full text-xs font-bold uppercase ${styles[type]}`}>
      {children}
    </span>
  );
};


// -(APP) ################

export default function MainPage() {
  const [view, setView] = useState('home'); 
  const [abaInterna, setAbaInterna] = useState('materiais');

  // falso
  const user = { nome: "João Mavingue", zona: "Bairro Central" };

  return (
    <div className="min-h-screen  bg-gray-100 text-slate-900">
      
      
{/* navbar */}
      <nav className="sticky top-0 z-50 bg-gray-950/95 backdrop-blur-md   px-6 py-4" style={{backdropFilter:"blur(0px)"}}>
        <div className="max-w-7xl mx-auto flex justify-between items-center">
          <div className="flex items-center gap-2 cursor-pointer" onClick={() => setView('home')}>
            <span className="font-black text-xl text-orange-600">MAVINGUE</span>
          </div>
          
          <div className="flex gap-6 items-center">
            <button 
              onClick={() => setView('home')}
              className={`text-sm font-bold ${view === 'home' ? 'text-orange-600' : 'text-gray-500'}`}
            >
              Início
            </button>
            <button 
              onClick={() => setView('dashboard')}
              className={`px-4 py-2 rounded-lg text-sm font-bold transition ${view === 'dashboard' ? 'bg-orange-600 text-white' : 'bg-gray-100 text-gray-700'}`}
            >
              Minha Área
            </button>
          </div>
        </div>
      </nav>

      {/* CONDICIOn */}
      {view === 'home' ? (
        <>
          <HeroIntro />
          <CatalogoProdutos />
        </>
      ) : (
        <div className="max-w-6xl w-full px-6 py-12">
          <header className="mb-10">
            <h1 className="text-3xl font-black">Área do Cliente</h1>
            <p className="text-gray-500">Bem-vindo, {user.nome} • {user.zona}</p>
          </header>

          {/* Servicos */}
          <div className="flex gap-2 mb-8 bg-gray-200 p-1 rounded-xl w-fit">
            <button 
              onClick={() => setAbaInterna('materiais')}
              className={`px-6 py-2 rounded-lg text-sm font-bold transition ${abaInterna === 'materiais' ? 'bg-white shadow-sm text-orange-600' : 'text-gray-500'}`}
            >
              Materiais
            </button>
            <button 
              onClick={() => setAbaInterna('agua')}
              className={`px-6 py-2 rounded-lg text-sm font-bold transition ${abaInterna === 'agua' ? 'bg-white shadow-sm text-blue-600' : 'text-gray-500'}`}
            >
              Água
            </button>
          </div>

          {/* Dash */}
          {abaInterna === 'materiais' ? (
            <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
              <Card className="md:col-span-2">
                <h3 className="font-bold mb-4">Histórico de Compras</h3>
                <div className="space-y-3">
                  <div className="flex justify-between p-3 bg-gray-50 rounded-lg text-sm">
                    <span>Venda #102 - Cimentw (20 sacos)</span>
                    <span className="font-bold">11,000 MT</span>
                  </div>
                  <div className="flex justify-between p-3 bg-gray-50 rounded-lg text-sm text-orange-600">
                    <span>Venda #105 - Pendente de Entrega</span>
                    <span className="font-bold">5,400 MT</span>
                  </div>
                </div>
              </Card>
              <Card className="bg-orange-600 text-white">
                <h3 className="font-bold mb-2">Aviso</h3>
                <p className="text-sm opacity-90 text-orange-600 ">
                  Lembre-se: Após a venda, não aceitamos devoluções. Pode comprar mesmo sem stock para reserva.
                </p>
              </Card>
            </div>
          ) : (
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <Card>
                <div className="flex justify-between items-start mb-6">
                  <div>
                    <h3 className="font-bold text-lg">Consumo Mensal</h3>
                    <p className="text-xs text-gray-400">Contador: MZ-002</p>
                  </div>

                  <Badge>Ligação Activa</Badge>
               
                </div>
                <div className="text-3xl font-black text-blue-600">42.5 m³</div>
                <p className="text-sm text-gray-500">Referente a Janeiro 2026</p>
              </Card>
              <Card>
                <h3 className="font-bold mb-4">Última Factura</h3>
                <div className="flex justify-between items-center">
                  <span className="text-2xl font-bold">1,250 MT</span>
                  <Badge type="warning">Pendente</Badge>
                </div>
                <button className="w-full mt-4 bg-blue-600 text-white py-2 rounded-lg font-bold text-sm">
                  Pagar Via M-Pesa
                </button>
              </Card>
            </div>
          )}
        </div>
      )}

      <footer className="bg-gray-900/90 py-1 text-center">
        <p className="text-gray-400 text-sm">© 2026 Mavingue Gestão. Todos os direitos reservados.</p>
      </footer>
    </div>
  );
}