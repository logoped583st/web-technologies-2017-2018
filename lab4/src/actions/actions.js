export const fetchSuccess = (responce)=>(dispatch)=>  {
    return dispatch(
        {
            type: 'RESPONCE_SUCCESS_USER',
            data: {
                image: responce.avatar_url,
                name: responce.name,
                login: responce.login,
                bio: responce.bio,
                blog: responce.blog,
                company: responce.company,
                location: responce.location,
                email: responce.email,
                social: responce.social
            }
        }
    )
};


export const fetchSuccessOrg = (responce)=>(dispatch)=>  {
    console.log(responce);
    if(responce.length===0){
        console.log("EMPTY");
        return dispatch(
            {
                type: 'RESPONCE_SUCCESS_ORGS_EMPTY',
            }
        )
    }
    responce.map(obj=>{
        return dispatch(
            {
                type: 'RESPONCE_SUCCESS_ORGS',
                data: {
                    image: obj.avatar_url,
                    login: obj.login,
                }
            }
        )
    })
  
};