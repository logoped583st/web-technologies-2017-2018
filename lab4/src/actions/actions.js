
export const fetchSuccess = (responce)=>(dispatch)=>  {
    console.log(responce)
    return dispatch(
        {
            type: 'GET_SUCCESS',
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