/**
 * Renders a single pet item.
 *
 * @param {Object} props - The properties passed to the component.
 * @param {Object} props.pet - The pet object containing the pet's name and pet type.
 * @return {JSX.Element} - The rendered pet item.
 */
function PetItem({pet}) {
    return (
        <div>
            <p>{pet.name} | {pet.petType}</p>
        </div>
    )
}
export default PetItem