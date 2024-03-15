

/**
 * Function component for rendering a tenant item.
 *
 * @param {Object} tenant - The details of the tenant to be displayed
 * @return {JSX.Element} Rendered component for the specific tenant
 */
function TenantItem({tenant}) {
    return (
        <div>
            <p>{tenant.firstName} {tenant.lastName} {tenant.email} {tenant.phoneNumber}</p>
        </div>
    )
}
export default TenantItem;