import React from 'react';

const Layout = ({ children }: { children: React.ReactNode }) => {
  return (

    <div>

        
   
    
        {children}
      
      <footer className="bg-gray-900/90 py-4 text-center border-t border-gray-800">
        <p className="text-gray-400 text-sm">
          © 2026 Mavingue Gestão. Todos os direitos reservados.
        </p>
      </footer>
    </div>
  );
};

export default Layout;