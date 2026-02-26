
const Layout = ({children} : {children: React.ReactNode}) =>{
    return(
         <div  
      style={{ backgroundImage: "linear-gradient(rgba(0,0,0,0.4), rgba(0,0,0,0.4)), url('/imgs/login.jpg')",
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        backgroundAttachment: 'fixed'}}>

                
             {children}
         </div>
    )
}

export default Layout;