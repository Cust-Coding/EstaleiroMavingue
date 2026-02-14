'use client'







export default function CatalogoProdutos() {
  // Dados simulados do Backend
  const produtos = [
    { id: 1, nome: 'Cimento Portland', preco: 550, imagem: '/cimento.jpg' },
    { id: 2, nome: 'Varão 12mm', preco: 420, imagem: '/varao.jpg' },
     { id: 3, nome: 'Cimento Portland', preco: 550, imagem: '/cimento.jpg' },
    { id: 4, nome: 'Varão 12mm', preco: 420, imagem: '/varao.jpg' },
     { id: 5, nome: 'Varão 12mm', preco: 420, imagem: '/varao.jpg' },
     { id: 6, nome: 'Cimento Portland', preco: 550, imagem: '/cimento.jpg' },
    { id: 7, nome: 'Varão 12mm', preco: 420, imagem: '/varao.jpg' },
    
  ];

  return (
    <div className="p-20">
      <h1 className="text-3xl font-bold mb-8 text-slate-800">Materiais Disponíveis</h1>
      <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
        {produtos.map(p => (
          <div key={p.id} className="bg-gray-200 rounded-2xl shadow-sm  p-4 hover:shadow-md transition">
            <div className="h-40 bg-slate-100 rounded-xl mb-4 flex items-center justify-center text-slate-400">
              Imagem do Produto
            </div>
            <h3 className="font-bold text-lg  text-gray-500/70">{p.nome}</h3>
            <p className="text-blue-600 font-black text-xl">{p.preco} MT</p>
            <button className="w-full mt-4 bg-slate-900 text-white py-3 rounded-xl flex items-center justify-center gap-2 hover:bg-slate-800">
              Comprar <img src="/shoping.svg" alt="shoping icon" className="size-5" />
            </button>
           
          </div>
        ))}
      </div>
    </div>
  );
}